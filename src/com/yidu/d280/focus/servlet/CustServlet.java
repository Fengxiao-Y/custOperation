package com.yidu.d280.focus.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.yidu.d280.dao.focus.impl.CustDaoImpl;
import com.yidu.d280.focus.dao.CustDao;
import com.yidu.d280.focus.domain.Cust;

/**
 * Servlet implementation class CustServlet
 */
@WebServlet("/CustServlet")
public class CustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		
		String method=request.getParameter("method");
		//System.out.println("method:"+method);
		if("findAll".equals(method)){
			this.findAll(request,response);
		}else if("add".equals(method)){
			this.add(request,response);
		}else if("update".equals(method)){
			this.update(request,response);
		}else if("delete".equals(method)){
			this.delete(request,response);
		}
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//��ȡ�������������ݹ�����Ա������ַ���
		String cidStr=request.getParameter("cidStr");
		//���ַ������а�","(����)�ָ�����ַ�������
		String[] cids=cidStr.split(",");
		
		//�������ݲ��������
		CustDao custDao=new CustDaoImpl();
		
		//����������ɾ�����п���ʧ�ܣ��˴�ʹ���쳣������ʵ��
		try{
			//ʹ��ѭ����������ɾ��
			for(int i=0;i<cids.length;i++){
				//��ȡ��ǰ���ַ���
				String cid=cids[i];
				//ִ��ɾ������
				custDao.deleteById(cid);
			}
			out.print("success");
		}catch(Exception e){
			out.print("failure");
		}
		//�ر��������
		out.close();
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		//�������Կͻ��˵�����
		
		String cid=request.getParameter("cid");
		String cname=request.getParameter("cname");
		String sex=request.getParameter("sex");
		String telphone=request.getParameter("telphone");
		String cardDate=request.getParameter("cardDate");
		double rateMoney=Double.parseDouble(request.getParameter("rateMoney"));
		String eno=request.getParameter("eno");
		
		//���ݷ�װ�ɶ���
		Cust cust=new Cust(cid, cname, sex, telphone, cardDate, rateMoney, eno);
		
		//�������ݲ����ִ����ӷ���
		CustDao empDao=new CustDaoImpl();
		int rows=empDao.update(cust);
		//�ж��޸��Ƿ�ɹ�
		if(rows>0){
			out.print("success");
		}else{
			out.print("failure");
		}
		
		out.close();
	}

	/**
	 * ����
	 * @param request
	 * @param response
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//System.out.println("1111");
		//�������Կͻ��˵�����
		String cid=request.getParameter("cid");
		String cname=request.getParameter("cname");
		String sex=request.getParameter("sex");
		String telphone=request.getParameter("telphone");
		String cardDate=request.getParameter("cardDate");
		double rateMoney=Double.parseDouble(request.getParameter("rateMoney"));
		String eno=request.getParameter("eno");
		
		//���ݷ�װ�ɶ���
		Cust cust=new Cust(cid, cname, sex, telphone, cardDate, rateMoney, eno);
		//System.out.println("2222");
		//�������ݲ����ִ����ӷ���
		CustDao custDao=new CustDaoImpl();
		int rows=custDao.add(cust);
		//�ж�����Ƿ�ɹ�
		if(rows>0){
			out.print("success");
			//System.out.println("3333");
		}else{
			out.print("failure");
			//System.out.println("4444");
		}
		
		out.close();
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		/*
		//�õ����������е���������
		String empName=request.getParameter("empName");
		String job=request.getParameter("job");
		String deptno=request.getParameter("deptno");
		
		//���ɲ�ѯ����
		//select * from ���� where ���� limit n1,n2 
		//where �ֶ���=? and �ֶ���=? and �ֶ���=?
		String condition=" where 1=1 ";
		//���������ݽ����жϲ���ϳɲ�ѯ����
		if(empName!=null && !empName.equals("")){
			condition=condition+"and empName like '%"+empName+"%' ";
		}
		
		if(job!=null && !job.equals("")){
			condition=condition+"and job like '%"+job+"%' ";
		}
		
		if(deptno!=null && !deptno.equals("")){
			//����deptno��int���ͣ�����ת������
			int dept=Integer.parseInt(deptno);
			//��ӵ�������
			condition=condition+"and deptno="+dept+" ";
		}
		
		System.out.println("condition="+condition);
		*/
		//�������Կͻ��˵�datagrid����Ĵ��ݹ�����page��rows����
		int rows=Integer.parseInt(request.getParameter("rows"));
		int page=Integer.parseInt(request.getParameter("page"));
		
		//�������ݲ�ִ�з�ҳ��ѯ
		CustDao custDao=new CustDaoImpl();
		//��õ�ǰҳ�����ݼ���
		List<Cust> custList=custDao.findByPage(rows, page);
		//��ѯ��emp����ܼ�¼��
		int totalRows=custDao.count();
		
		//A��ʽ��
		/*
		//�����ݼ���ת����JSON���ݸ�ʽ
		String jsonStr=JSONArray.fromObject(empList).toString();
		//���ɸ�ʽ������
		String json="{\"total\":"+totalRows+",\"rows\":"+jsonStr+"}";
		*/
		
		//B:��ʽ
		//����ӳ�伯�϶���
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("total", totalRows);
		mapData.put("rows", custList);
		//����Gson����
		Gson gson = new Gson();
		//ͨ��Gson����Map����ת����json���ݸ�ʽ
		String jsonData = gson.toJson(mapData);
		//��json����������ͻ���
		out.println(jsonData);
		//System.out.println(jsonData);
		out.close();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

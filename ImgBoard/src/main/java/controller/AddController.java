package controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Product;
import service.Service;
import service.ServiceImpl;

/**
 * Servlet implementation class AddController
 */
@WebServlet("/seller/Add")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Service service = new ServiceImpl();


		Product p = new Product();
		
		p.setNum(service.makeNum());
		
		String img = "";
		
		int maxSize =1024 *1024 *10;
		MultipartRequest multi = null;
		String uploadPath = "C:\\web2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\shop_img";
		try {
			// request,����������,�뷮,���ڵ�Ÿ��,�ߺ����ϸ� ���� �⺻ ��å
			multi = new MultipartRequest(request, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
			p.setName(multi.getParameter("name"));
			p.setQuantity(Integer.parseInt(multi.getParameter("quantity")));
			p.setPrice(Integer.parseInt(multi.getParameter("price")));
			p.setContent(multi.getParameter("content"));
			// ������ ��ü �����̸����� ������
			Enumeration files = multi.getFileNames();

			while (files.hasMoreElements()) {
				// form �±׿��� <input type="file" name="���⿡ ������ �̸�" />�� �����´�.
				String file1 = (String) files.nextElement();// ���� input�� ������ �̸��� ������
				// �׿� �ش��ϴ� ���� ���� �̸��� ������
				img = multi.getOriginalFileName(file1);
				//���Ͼ��ε�
				File file = multi.getFile(file1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		p.setImg("/shop_img/" + img);
		service.add(p);
		response.sendRedirect("/ImgBoard/seller/List");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

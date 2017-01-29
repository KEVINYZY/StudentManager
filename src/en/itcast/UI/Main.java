package en.itcast.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import en.itcast.dao.StudentDao;
import en.itcast.domain.Student;
import en.itcast.exception.StudentNotExistException;

public class Main {

	public static void main(String[] args) {
		System.out.println("����û�(a) ɾ���û�(b) �����û�(c)");
		System.out.print("�������������:");

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			String type = bf.readLine();

			if ("a".equals(type)) {
				System.out.print("������ѧ������:");
				String name = bf.readLine();

				System.out.print("������ѧ��׼��֤��:");
				String examid = bf.readLine();

				System.out.print("������ѧ�����ڵ�:");
				String location = bf.readLine();

				System.out.print("������ѧ�����֤:");
				String idcard = bf.readLine();

				System.out.print("������ѧ���ɼ�:");
				String grade = bf.readLine();

				Student s = new Student();
				s.setExamid(examid);
				s.setGrade(Double.parseDouble(grade));
				s.setIdcard(idcard);
				s.setLocation(location);
				s.setName(name);

				StudentDao dao = new StudentDao();
				dao.add(s);

				System.out.println("��ӳɹ�");
			} else if ("b".equals(type)) {
				System.out.print("������Ҫɾ����ѧ������:");
				String name = bf.readLine();
				try {
					StudentDao dao = new StudentDao();
					dao.delete(name);
					System.out.println("ɾ���ɹ�.");
				} catch (StudentNotExistException e) {
					System.out.println("��ɾ�����û�������.");
				}

			} else if ("c".equals(type)) {
				System.out.print("��������Ҫ��ѯ��׼��֤id:");
				String examid = bf.readLine();
				StudentDao dao = new StudentDao();
				Student find_student = dao.find(examid);
				if(find_student.equals(null)){
					System.out.println("�Բ����Ҳ�����ѧ��.");
				}else{
					System.out.println("��ѧ����������:"+find_student.getName());
				}
			} else {
				System.out.println("��֧����Ĳ���");

			}
		} catch (IOException e) {
			e.printStackTrace();
			;
			System.out.println("sorry");
		}

	}

}

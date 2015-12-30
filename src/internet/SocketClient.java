package internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	public static void main(String[] args) {

		Socket socket;
		try {
			socket = new Socket("127.0.0.1", 4700);
			BufferedReader sin = new BufferedReader(new InputStreamReader(
					System.in));
			// ��ϵͳ��׼�����豸����BufferedReader���� ��
			PrintWriter os = new PrintWriter(socket.getOutputStream());// ��Socket����õ��������������PrintWriter����
			String readline;
			readline = sin.readLine(); // ��ϵͳ��׼�������һ�ַ���
			while (!readline.equals("bye")) {// ���ӱ�׼���������ַ���Ϊ "bye"��ֹͣѭ��
				os.println(readline);// ����ϵͳ��׼���������ַ��������Server
				os.flush();// ˢ���������ʹServer�����յ����ַ���
				System.out.println("Client:" + readline);// ��ϵͳ��׼����ϴ�ӡ������ַ���
				// System.out.println("Server:"+is.readLine());//��Server����һ�ַ���������ӡ����׼�����
				readline = sin.readLine(); // ��ϵͳ��׼�������һ�ַ���

			}
			// ����ѭ�� ��
			os.close(); // �ر�Socket�����
			// is.close(); //�ر�Socket������ ��
			socket.close();// �ر�Socket
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// �򱾻���4700�˿ڷ����ͻ�����

	}
}

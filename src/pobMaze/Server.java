package pobMaze;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

public class Server {
	static int port = 5555;

	public static void main (String [] args) {
		try {
			
			PropertyHandlerMapping mapping = new PropertyHandlerMapping();
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			mapping.load(cl,"server.properties");

			System.out.println("Attempting to start XML-RPC Server...");
			WebServer webServer = new WebServer(port);

			XmlRpcServerConfigImpl config = new XmlRpcServerConfigImpl();
			XmlRpcServer server = webServer.getXmlRpcServer();
			server.setConfig(config);
			server.setHandlerMapping(mapping);

			webServer.start();
			System.out.println("Started successfully.");
			System.out.println("Accepting requests. (Halt program to stop.)");

		} catch (Exception exception) {
			System.err.println("Server: " + exception);
			exception.printStackTrace();
		}
	}
}
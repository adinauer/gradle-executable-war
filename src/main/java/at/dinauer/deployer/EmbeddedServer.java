package at.dinauer.deployer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import java.security.ProtectionDomain;

public class EmbeddedServer {
	public static void main(String[] args) throws Exception {
		Server server = new Server(8081);

		WebAppContext webApp = new WebAppContext();
		webApp.setContextPath("/");
		ProtectionDomain protectionDomain = EmbeddedServer.class.getProtectionDomain();
		webApp.setWar(protectionDomain.getCodeSource().getLocation().toExternalForm());

		server.setHandler(webApp);

		server.start();
		server.join();
	}
}
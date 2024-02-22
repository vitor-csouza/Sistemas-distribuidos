import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	
	public Server() {
		
	}

	public static void main(String[] args) {
		
		try {
			
			HelloImplementation obj = new HelloImplementation();
			HelloInterface stub = (HelloInterface) UnicastRemoteObject.exportObject(obj, 1099);
			
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("Hello interface", stub);
			System.out.println("Servidor em execução...");
			
		} catch(Exception e) {
			System.out.println("ERRO: "+e.getMessage());
			e.printStackTrace();
		}

	}

}

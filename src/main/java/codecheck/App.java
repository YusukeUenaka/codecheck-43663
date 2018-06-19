package codecheck;

public class App {
	public static void main(String[] args) {
		for (int i = 0, l = args.length; i < l; i++) {
			String output = String.format("argv[%s]: %s", i, args[i]);
			System.out.println(output);
		
		
			WebTarget target = client.target("http://challenge-server.code-check.io")
					.path("/api/hash") 
					.queryParam("q",arg[i]);
			
			try {
			    String result = target.request().get(String.class);
			    System.out.println(result);
			} catch (BadRequestException e) {
			    logger.error("response=" + e.getResponse().readEntity(String.class), e);
			    throw e;
			}
		}
	}
}

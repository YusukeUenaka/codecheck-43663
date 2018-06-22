package codecheck;

public class App {
	public static void main(String[] args) {
		for (int i = 0, l = args.length; i < l; i++) {
			String output = String.format("argv[%s]: %s", i, args[i]);
			System.out.println(output);
		
		
			/*WebTarget target = client.target("http://challenge-server.code-check.io")
					.path("/api/hash") 
					.queryParam("q",arg[i]);
			
			try {
			    String result = target.request().get(String.class);
			    System.out.println(result);
			} catch (BadRequestException e) {
			    logger.error("response=" + e.getResponse().readEntity(String.class), e);
			    throw e;
			}*/
		}
		
		try {
            URL url = new URL("http://challenge-server.code-check.io/api/hash/");
            url += arg[1].toString();

            HttpURLConnection connection = null;

            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    try (InputStreamReader isr = new InputStreamReader(connection.getInputStream(),
                                                                       StandardCharsets.UTF_8);
                         BufferedReader reader = new BufferedReader(isr)) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    }
                }
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}

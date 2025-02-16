package restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredExample { 
    
        public static void main (String[] args) {
            // getAllObjects(); 
            // getlistObjects();
            // getSingleObjects();
            // addobjects();
            //  updateobjects();
               deleteobjects();
    }

    public static void getAllObjects() {  
        RestAssured.baseURI = "https://restful-api.dev";
        RequestSpecification requestSpecification = RestAssured.given();

        Response response = requestSpecification
                                .log().all()
                                .get("objects");

        System.out.println("Hasilnya adalah: \n" + response.asPrettyString());
    }


    public static void getlistObjects() {  
        RestAssured.baseURI = "https://api.restful-api.dev/objects?id=3&id=5&id=10";
        RequestSpecification requestSpecification = RestAssured.given();

        Response response = requestSpecification
                                .log().all()
                                .get("objects");

        System.out.println("Hasilnya adalah: \n" + response.asPrettyString());
    }


    public static void getSingleObjects() {  
        RestAssured.baseURI = "https://api.restful-api.dev/objects/7";
        RequestSpecification requestSpecification = RestAssured.given();

        Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("idobjects", 7)
                                .pathParam("path", "objects")
                                .header("Authorization", "Berear" )
                                .when()
                                .get("objects/1");

        System.out.println("Hasilnya adalah: \n" + response.asPrettyString());
    }

    public static void getaddobjects(){

            String json = "{\n" + //
            "            \"title\": \"Apple MacBook Pro 16\",\n" + //
            "            \"price\": \"1849.99\",\n" + //
            "            \"cpu model\": \"Intel Core i9\"\n" + //
            "             \"Hard disk size\": \"1 TB\",\n" + //";
            "}";
    
            RestAssured.baseURI = "https://api.restful-api.dev/objects";
            RequestSpecification requestSpecification = RestAssured
                                                        .given();
    
            Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "objects")
                                .pathParam("method", "add")
                                .body(json)
                                .contentType("application/json")
                                .when()
                                    .post("{path}/{method}");
            System.out.println("add objects" + response.asPrettyString());
        }

        public static void updateobjects(){

            String json = "{\n" + //
            "            \"title\": \"Apple new 16\",\n" + //
            "            \"price\": \"1249.99\",\n" + //
            "            \"cpu model\": \"Intel Core i8\"\n" + //
            "             \"Hard disk size\": \"1 TB\",\n" + //";
            "}";
    
            RestAssured.baseURI = "https://api.restful-api.dev/objects/7";
            RequestSpecification requestSpecification = RestAssured
                                                        .given();
    
            Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "objects")
                                .pathParam("id objects", "7")
                                .body(json)
                                .contentType("application/json")
                                .when()
                                    .put("{path}/{id objects}");
            System.out.println("update objects" + response.asPrettyString());
        }

        public static void deleteobjects(){
            RestAssured.baseURI = "https://api.restful-api.dev/objects/6";
            RequestSpecification requestSpecification = RestAssured
                                                        .given();
    
            Response response = requestSpecification
                                .log()
                                .all()
                                .pathParam("path", "objects")
                                .pathParam("idobjects", "6")
                                .contentType("application/json")
                                .when()
                                    .delete("{path}/{idobjects}");
            System.out.println("delete objects" + response.asPrettyString());
    
        }
}
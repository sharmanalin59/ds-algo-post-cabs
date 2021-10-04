/*
package razor.pay;

*/
/**
 * @author nalin.sharma on 19/06/21
 *//*

public class Driver {
    public static void main(String[] args) {
        IDocumentService docService = new DocumentService();
        docService.addUser("Paul Mccartney", "paul@gmail.com","pass"); // id 1
        docService.createDoc(1, "White Album", "White Album","1.\t\"Back in the U.S.S.R.\"\tMcCartney\t2:43\n" +
                "2.\t\"Dear Prudence\"\tLennon\t3:56\n" +
                "3.\t\"Glass Onion\"\tLennon\t2:18\n" +
                "4.\t\"Ob-La-Di, Ob-La-Da\"\tMcCartney\t3:08\n" +
                "5.\t\"Wild Honey Pie\"\tMcCartney\t0:52\n" +
                "6.\t\"The Continuing Story of Bungalow Bill\"\tLennon, with Yoko Ono\t3:14\n" +
                "7.\t\"While My Guitar Gently Weeps\" (George Harrison)\tHarrison\t4:45\n" +
                "8.\t\"Happiness Is a Warm Gun\"", true, false);

        System.out.println("Paul Mccartney can view doc(White Album) : " + docService.view(1, "White Album"));
        docService.addUser("John Lennon", "joh@gmail.com", "pass"); //id 2
        System.out.println("John Lennon can view doc(White Album) : " + docService.view(2, "White Album"));
        docService.updateDocAndUsers(1, null, "White Album", "1.\t\"Martha My Dear\"\tMcCartney\t2:28\n" +
                "2.\t\"I'm So Tired\"\tLennon\t2:03\n" +
                "3.\t\"Blackbird\"\tMcCartney\t2:18\n" +
                "4.\t\"Piggies\" (Harrison)\tHarrison\t2:04\n" +
                "5.\t\"Rocky Raccoon\"\tMcCartney\t3:33\n" +
                "6.\t\"Don't Pass Me By\" (Richard Starkey)\tStarr\t3:51\n" +
                "7.\t\"Why Don't We Do It in the Road?\"\tMcCartney\t1:41\n" +
                "8.\t\"I Will\"\tMcCartney\t1:46\n" +
                "9.\t\"Julia\"", "", true, true, true, true);
        System.out.println("John Lennon can view doc(White Album) : " + docService.view(2, "White Album"));
        docService.updateDocAndUsers(2, null, "White Album", "1.\t\"Birthday\"\tMcCartney with Lennon\t2:42\n" +
                "2.\t\"Yer Blues\"\tLennon\t4:01\n" +
                "3.\t\"Mother Nature's Son\"\tMcCartney\t2:48\n" +
                "4.\t\"Everybody's Got Something to Hide Except Me and My Monkey\"\tLennon\t2:24\n" +
                "5.\t\"Sexy Sadie\"\tLennon\t3:15\n" +
                "6.\t\"Helter Skelter\"\tMcCartney\t4:30\n" +
                "7.\t\"Long, Long, Long\" (Harrison)", "", null, null, null, null);
        System.out.println(docService.deleteDoc(2, "White Album"));
        System.out.println(docService.deleteDoc(1, "White Album"));
    }
}
*/

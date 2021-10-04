package razor.pay;

/**
 * @author nalin.sharma on 19/06/21
 */
public interface IDocumentService {

    boolean addUser(String userName, String email, String pass);
    Document createDoc(long userId, String docName, String desc, String content,
                       Boolean view, Boolean update);
    Document view(long userId, String docName);
    boolean updateDocAndUsers(long userId, Long userAdded,
                      String docName, String content,
                              String desc, Boolean viewG, Boolean updateG,
                              Boolean view, Boolean update);

    boolean deleteDoc(long userId, String docName);

}

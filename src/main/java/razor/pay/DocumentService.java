/*
package razor.pay;

import com.google.common.base.Strings;

import java.io.*;
import java.util.*;

*/
/**
 * @author nalin.sharma on 19/06/21
 *//*

public class DocumentService implements IDocumentService {

    int docCnt = 1;
    Map<String, Document> docStore = new HashMap<>();

    long userCnt = 1;
    Map<Long, User> users = new HashMap<>();

    Map<Long, Map<Long, DocumentUser>> docUsersPermission = new HashMap<>();

    String fileName = "doc_";
    String absolutePath = "/Users/nalinsharma/name/nalin/src/main/java/razor/pay/doc";

    @Override
    public Document view(long userId, String docName) {
        if(!docStore.containsKey(docName) || docStore.get(docName).isDelete()) {
            throw new RuntimeException("Doc not found");
        }
        Document doc = docStore.get(docName);
        if(doc.getCreated_by_userId() == userId) {
            return doc;
        }
        Map<Long, DocumentUser> map = docUsersPermission.get(doc.getId());
        if(map == null || !map.containsKey(userId) || Objects.isNull(map.get(userId).isView()) ||
                !map.get(userId).isView()) {
            //throw new RuntimeException("No permission");
            if(doc.isView()) {
                return doc;
            }
            else {
                return null;
            }
        }

        return null;
    }

    @Override
    public Document createDoc(long userId, String docName, String desc, String content, Boolean viewG, Boolean updateG) {
        if(!users.containsKey(userId)) {
            throw new DocumentCreationException("File could not be created, user doesn't exist");
        }
        if(Strings.isNullOrEmpty(content)) {
            throw new DocumentCreationException("File could not be created, content empty");
        }
        if(docStore.containsKey(docName) && !docStore.get(docName).isDelete()) {
            throw new DocumentCreationException("File could not be created, file name already exists");
        }
        fileName += (docCnt++);

        createFile(absolutePath+fileName, content);

        //create doc
        Document doc = new Document(docName, desc, absolutePath+fileName, userId);
        if(!Objects.isNull(viewG)) {
            doc.setView(viewG);
        }
        if(!Objects.isNull(updateG)) {
            doc.setUpdate(updateG);
        }
        docStore.putIfAbsent(docName, doc);
        return doc;
    }

    void createFile(String file, String content) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            throw new DocumentCreationException("File could not be created " + e.getMessage());
        }
    }

    void deleteFile(String file_uri) {
        File file = new File(file_uri);

        if (file.delete()) {
            System.out.println("File " + file_uri + "deleted successfully");
        } else {
            System.out.println("Failed to delete the file " + file_uri);
        }
    }

    @Override
    public boolean updateDocAndUsers(long userId, Long userAdded,
                             String docName, String content, String desc, Boolean viewG, Boolean updateG, Boolean view, Boolean update) {
        if(!docStore.containsKey(docName) || docStore.get(docName).isDelete()) {
            return false;
        }
        Document doc = docStore.get(docName);
        //Admin authentication required
        if(doc.getCreated_by_userId() == userId) {
            if (!Objects.isNull(viewG)) {
                doc.setView(viewG);
            }
            if (!Objects.isNull(updateG)) {
                doc.setUpdate(updateG);
            }

            if(userAdded != null) {
                if (docUsersPermission.get(doc.getId()) == null) {
                    docUsersPermission.put(doc.getId(), new HashMap<>());
                }
                docUsersPermission.get(doc.getId()).put(userAdded, new DocumentUser(userAdded, doc.getId(),
                        view, update));
            }
            //delete
            deleteFile(doc.getDoc_uri());
            createFile(absolutePath + fileName, content);
            //rewrite
            return true;
        }

        //Other user
        Map<Long, DocumentUser> umap = docUsersPermission.get(doc.getId());
        if(umap != null && umap.containsKey(userId) && umap.get(userId).isUpdate() != null) {
            if(umap.get(userId).isUpdate()) {
                deleteFile(doc.getDoc_uri());
                createFile(absolutePath + fileName, content);
                return true;
            }
            else {
                return false;
            }
        }
        else if(doc.isUpdate()){
            deleteFile(doc.getDoc_uri());
            createFile(absolutePath + fileName, content);
            return true;
        }
        throw new RuntimeException("Unauthorized");
    }

    @Override
    public boolean deleteDoc(long userId, String docName) {
        if(!docStore.containsKey(docName) || docStore.get(docName).isDelete()) {
            throw new RuntimeException("Doc not found");
        }
        Document doc = docStore.get(docName);
        if(doc.getCreated_by_userId() == userId) {
            deleteFile(doc.getDoc_uri());
            docStore.remove(docName);
            docUsersPermission.remove(docName);
            return true;
        }
        return false;
    }

    @Override
    public boolean addUser(String userName, String email, String pass) {
        users.put(userCnt, new User(userCnt++, userName, email, pass));
        return true;
    }
}
*/

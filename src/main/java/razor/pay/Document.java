package razor.pay;

/**
 * @author nalin.sharma on 19/06/21
 */
public class Document {
    private long id;
    private String name;
    private String desc;
    private String doc_uri;
    private long created_by_userId;
    private boolean view = false;
    private boolean update = false;

    private boolean delete = false;


    public Document(String name, String desc, String doc_uri, long created_by_userId) {
        this.name = name;
        this.desc = desc;
        this.doc_uri = doc_uri;
        this.created_by_userId = created_by_userId;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getDoc_uri() {
        return doc_uri;
    }

    public long getCreated_by_userId() {
        return created_by_userId;
    }

    public Boolean isView() {
        return view;
    }

    public Boolean isUpdate() {
        return update;
    }

    public boolean isDelete() {
        return delete;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", doc_uri='" + doc_uri + '\'' +
                ", created_by_userId=" + created_by_userId +
                ", view=" + view +
                ", update=" + update +
                ", delete=" + delete +
                '}';
    }
}

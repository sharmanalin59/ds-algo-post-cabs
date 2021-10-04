package razor.pay;

/**
 * @author nalin.sharma on 19/06/21
 */
public class DocumentUser {
    private long userId;
    private long docId;
    private Boolean view;
    private Boolean update;

    public DocumentUser(long userId, long docId, Boolean view, Boolean update) {
        this.userId = userId;
        this.docId = docId;
        this.view = view;
        this.update = update;
    }

    public void setView(Boolean view) {
        this.view = view;
    }

    public void setUpdate(Boolean update) {
        this.update = update;
    }

    public long getUserId() {
        return userId;
    }

    public long getDocId() {
        return docId;
    }

    public Boolean isView() {
        return view;
    }

    public Boolean isUpdate() {
        return update;
    }
}

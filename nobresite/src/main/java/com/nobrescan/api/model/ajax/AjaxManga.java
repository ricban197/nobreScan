package com.nobrescan.api.model.ajax;
import com.nobrescan.api.model.Manga;
import java.util.List;

public class AjaxManga {
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    String msg;
    List<Manga> result;

    public List<Manga> getResult() {
        return result;
    }

    public void setResult(List<Manga> result) {
        this.result = result;
    }

}

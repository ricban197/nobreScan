package com.nobrescan.api.model.ajax;
import com.nobrescan.api.model.Capitulo;
import java.util.List;

public class AjaxCapitulo {
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    String msg;
    List<Capitulo> result;

    public List<Capitulo> getResult() {
        return result;
    }

    public void setResult(List<Capitulo> result) {
        this.result = result;
    }
}

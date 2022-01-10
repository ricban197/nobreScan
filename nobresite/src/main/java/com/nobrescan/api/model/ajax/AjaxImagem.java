package com.nobrescan.api.model.ajax;

import com.nobrescan.api.model.Imagem;

import java.util.List;

public class AjaxImagem {
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    String msg;
    List<Imagem> result;

    public List<Imagem> getResult() {
        return result;
    }

    public void setResult(List<Imagem> result) {
        this.result = result;
    }
}

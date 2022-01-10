package com.nobrescan.api.model.ajax;


import com.nobrescan.api.model.Usuarios;

import java.util.List;

public class AjaxUsuarios {

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    String msg;
    List<Usuarios> result;

    public List<Usuarios> getResult() {
        return result;
    }

    public void setResult(List<Usuarios> result) {
        this.result = result;
    }


}
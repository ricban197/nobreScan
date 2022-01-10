package com.nobrescan.api.controller;
import com.nobrescan.api.model.ajax.AjaxUsuarios;
import com.nobrescan.api.model.validacao.UsuarioValida;
import com.nobrescan.api.model.Usuarios;
import com.nobrescan.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "192.168.0.106:8080")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @PostMapping("/logar")
    public UsuarioValida getSearchResultViaAjax(@RequestBody UsuarioValida b, Errors errors) {

        AjaxUsuarios result = new AjaxUsuarios();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return b;

        }
        List<Usuarios> a = usuarioRepository.findByUser(b.getUser());
        if(a.isEmpty()){
            b.setId((long)-1);//-1 usuario invalido
        }else if((a.get(0).getSenha()).equals(b.getSenha())){
            b.setId(a.get(0).getId());
            b.setUser(a.get(0).getUser());
            b.setNickname(a.get(0).getNickname());
            b.setAutorizacao(a.get(0).getAutorizacao());
            b.setSenha("aaaaaaaaaaaaa");

        }else{
            b.setId((long)-2);//-2 senha invalida
        }

        return b;
    }

    @PostMapping("/add")
    public Usuarios cadastrar(Usuarios user) {

        List<UsuarioValida> a =existe(user.getUser());
        if(a.size()==0){
            Usuarios novo =new Usuarios(user.getUser(),user.getSenha(),user.getNickname());
            usuarioRepository.save(novo);
            return novo;
        }else{
            user.setSenha("abv");
            return user;
      }

    }

    public List<UsuarioValida> existe(@RequestParam("user")String user){
        List<UsuarioValida> collect = this.usuarioRepository.findByUser(user)
                .stream()
                .map(UsuarioValida::converter)
                .collect(Collectors.toList());
        return collect;
        
    }


    /*
    @PostMapping("/logar")
    public @ResponseBody Usuarios logar(@RequestParam String user,@RequestParam String senha ){
        Usuarios u =new Usuarios();
        u.setUser(user);
        u.setSenha(senha);
        return u;
      /*  Usuarios a =new Usuarios();
        List<UsuariosRS> collect = this.usuarioRepository.findByuser(user)
                .stream()
                .map(UsuariosRS::converter)
                .collect(Collectors.toList());
        if(collect.size()==0){
                a.setId((long) -2);//user errado
            //ModelAndView mv =new ModelAndView("usuarios/login");
            //mv.addObject("a",a);
            //return mv;
            return "USER DESCONHECIDO";

        }else {

            String s = collect.get(0).getSenha();
            if (s.equals(senha)) {

                a.setUser(collect.get(0).getUser());
                a.setId(collect.get(0).getId());
                a.setAutorizacao(collect.get(0).getAutorizacao());
                a.setNickname(collect.get(0).getNickname());
                //ModelAndView mv =new ModelAndView("usuarios/home");
                //mv.addObject("a",a);
              //  return mv;
                return "LOGOU";

            } else {
                a.setNickname(senha);
                a.setUser(collect.get(0).getSenha());
                a.setId((long) -1);//senha errada
            //    ModelAndView mv =new ModelAndView("usuarios/login");
            //    mv.addObject("a",a);
            //    return mv;
                return "SENHA ERRADA";

            }
        }

    }
    public int pesquisa_autorizacao(Long id){
        Usuarios user =new Usuarios();
        user = usuarioRepository.findById(id).get();
        return user.getAutorizacao();

    }
*/
    /*

    UsuarioRepository usuarioRepository;
    @Autowired
    public void setUserService(UsuarioRepository userService) {
        this.usuarioRepository = userService;
    }
    @PostMapping("/api/search")
    public ResponseEntity<?> getSearchResultViaAjax(@RequestBody UsuarioValida search, Errors errors) {

        AjaxResponseBody result = new AjaxResponseBody();

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {

            result.setMsg(errors.getAllErrors()
                    .stream().map(x -> x.getDefaultMessage())
                    .collect(Collectors.joining(",")));

            return ResponseEntity.badRequest().body(result);

        }

        List<Usuarios> users = usuarioRepository.findByUser(search.getUser());
        if (users.isEmpty()) {
            result.setMsg("no user found!");
        } else {
            result.setMsg("success");
        }
        result.setResult(users);

        return ResponseEntity.ok(result);

    }*/
}

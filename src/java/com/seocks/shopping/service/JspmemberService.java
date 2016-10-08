package com.seocks.shopping.service;

import com.seocks.shopping.mapper.JspmemberMapper;
import com.seocks.shopping.model.Jspmember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by com on 2016-10-03.
 */
@Service
public class JspmemberService {

    @Autowired
    private JspmemberMapper jspmemberMapper;

    public int createUser(Jspmember jspmember)
    {
        return jspmemberMapper.createUser(jspmember);
    }

    public Jspmember getUser(String id)
    {
        return jspmemberMapper.getUser(id);
    }

    public List<Jspmember> getUsers()
    {
        return jspmemberMapper.getUsers();
    }

    public int updateUser(Jspmember jspmember)
    {
        return jspmemberMapper.updateUser(jspmember);
    }

}

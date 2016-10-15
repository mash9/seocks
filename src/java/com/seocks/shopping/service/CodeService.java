package com.seocks.shopping.service;

import com.seocks.shopping.mapper.CodeMapper;
import com.seocks.shopping.model.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by com on 2016-10-15.
 */
@Service
public class CodeService {

    @Autowired
    private CodeMapper codeMapper;

    public List<Code> getProductCodes()
    {
        return codeMapper.getProductCodes();
    }
}

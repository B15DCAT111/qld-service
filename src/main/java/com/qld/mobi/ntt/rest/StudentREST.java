package com.qld.mobi.ntt.rest;

import com.qld.mobi.ntt.bo.StudentBO;
import com.qld.mobi.ntt.buss.StudentBuss;
import com.qld.mobi.ntt.dto.StudentDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/student")
public class StudentREST {
    private final StudentBuss studentBuss;

    public StudentREST(StudentBuss studentBuss) {
        this.studentBuss = studentBuss;
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity save(@RequestBody StudentBO obj) {
        String result;
        try {
            studentBuss.save(obj);
            result = "Save to succesfull!";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("update")
    public ResponseEntity update(@RequestBody StudentBO obj) {
        String result;
        try {
            studentBuss.update(obj);
            result = "Save to succesfull!";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("saveOrUpdate")
    public ResponseEntity saveOrUpdate(@RequestBody StudentBO obj) {
        String result;
        try {
            studentBuss.saveOrUpdate(obj);
            result = "Save to succesfull!";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("remove")
    public ResponseEntity remove(@RequestBody StudentBO obj) {
        String result;
        try {
            studentBuss.remove(obj);
            result = "Save to succesfull!";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("do-search")
    public ResponseEntity doSearch(@RequestBody StudentDTO obj) {
        return new ResponseEntity(studentBuss.doSearch(obj), HttpStatus.OK);
    }
}

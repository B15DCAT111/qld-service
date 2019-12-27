package com.qld.mobi.ntt.rest;

import com.qld.mobi.ntt.bo.SubjectMarkBO;
import com.qld.mobi.ntt.buss.SubjectMarkBuss;
import com.qld.mobi.ntt.dto.SubjectMarkDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/sjm")
public class SubjectMarkREST {
    private final SubjectMarkBuss subjectMarkBuss;

    public SubjectMarkREST(SubjectMarkBuss subjectMarkBuss) {
        this.subjectMarkBuss = subjectMarkBuss;
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity save(@RequestBody SubjectMarkBO obj) {
        String result;
        try {
            subjectMarkBuss.save(obj);
            result = "Save to succesfull!";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("update")
    public ResponseEntity update(@RequestBody SubjectMarkBO obj) {
        String result;
        try {
            subjectMarkBuss.update(obj);
            result = "Save to succesfull!";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("saveOrUpdate")
    public ResponseEntity saveOrUpdate(@RequestBody SubjectMarkBO obj) {
        String result;
        try {
            subjectMarkBuss.saveOrUpdate(obj);
            result = "Save to succesfull!";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("remove")
    public ResponseEntity remove(@RequestBody SubjectMarkBO obj) {
        String result;
        try {
            subjectMarkBuss.remove(obj);
            result = "Save to succesfull!";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("do-search")
    public ResponseEntity doSearch(@RequestBody SubjectMarkDTO obj) {
        return new ResponseEntity(subjectMarkBuss.doSearch(obj), HttpStatus.OK);
    }
}

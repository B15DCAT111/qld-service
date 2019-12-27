package com.qld.mobi.ntt.rest;

import com.qld.mobi.ntt.bo.SubjectBO;
import com.qld.mobi.ntt.buss.SubjectBuss;
import com.qld.mobi.ntt.dto.SubjectDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/subject")
public class SubjectREST {
    private final SubjectBuss subjectBuss;

    public SubjectREST(SubjectBuss subjectBuss) {
        this.subjectBuss = subjectBuss;
    }

    @CrossOrigin
    @PostMapping("save")
    public ResponseEntity save(@RequestBody SubjectBO obj) {
        String result;
        try {
            subjectBuss.save(obj);
            result = "Save to succesfull!";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("update")
    public ResponseEntity update(@RequestBody SubjectBO obj) {
        String result;
        try {
            subjectBuss.update(obj);
            result = "Save to succesfull!";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("saveOrUpdate")
    public ResponseEntity saveOrUpdate(@RequestBody SubjectBO obj) {
        String result;
        try {
            subjectBuss.saveOrUpdate(obj);
            result = "Save to succesfull!";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("remove")
    public ResponseEntity remove(@RequestBody SubjectBO obj) {
        String result;
        try {
            subjectBuss.remove(obj);
            result = "Save to succesfull!";
        } catch (Exception e) {
            result = e.getMessage();
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("do-search")
    public ResponseEntity doSearch(@RequestBody SubjectDTO obj) {
        return new ResponseEntity(subjectBuss.doSearch(obj), HttpStatus.OK);
    }
}

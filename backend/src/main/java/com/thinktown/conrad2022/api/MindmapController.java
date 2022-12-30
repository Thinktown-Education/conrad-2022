package com.thinktown.conrad2022.api;

import com.thinktown.conrad2022.auth.GlobalUsercontext;
import com.thinktown.conrad2022.dao.Mindmap;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("mindmap")
public class MindmapController {

    @ApiOperation(value = "Get all mindmaps", notes = "It returns a list of mindmaps belongs to the user")
    @GetMapping("/getList")
    public ResponseEntity<List<Mindmap>> getList() {
        List<Mindmap> mindmaps = new ArrayList<>();
        return ResponseEntity.ok(mindmaps);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        int id = GlobalUsercontext.getUserId();
        return ResponseEntity.ok("User id: "  + id);
    }
}

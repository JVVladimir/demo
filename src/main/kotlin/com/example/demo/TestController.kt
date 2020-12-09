package com.example.demo

import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.convert.DurationUnit
import org.springframework.core.io.ByteArrayResource
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.InputStreamResource
import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.FileInputStream
import java.nio.file.Files
import java.nio.file.Path

@RestController
class TestController {

    // todo Скорость до 17 mb/s

    @GetMapping("/download")
    fun download(): ResponseEntity<Resource> {
        val fs = FileSystemResource("C:\\Users\\Vladimir\\IdeaProjects\\demo\\src\\main\\resources\\ironman.mkv")
       // val fs = FileInputStream("C:\\Users\\Vladimir\\IdeaProjects\\demo\\src\\main\\resources\\ironman.mkv")
        // val bytes = Files.readAllBytes(Path.of("C:\\Users\\Vladimir\\IdeaProjects\\demo\\src\\main\\resources\\ironman.mkv"))
        println("Started")
        return ResponseEntity.ok()
            .header("Content-Disposition", "attachment; filename=ironman.mkv")
            .contentLength(fs.contentLength())
            .contentType(MediaType.APPLICATION_OCTET_STREAM)
            .body(fs)
    }

    @GetMapping("/hello")
    fun test() = "Hello!"

}
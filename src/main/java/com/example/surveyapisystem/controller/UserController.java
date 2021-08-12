package com.example.surveyapisystem.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@Api(value = "Пользватели", description = "Чтобы получить подробную информацию о пользователе и опросы, принадлежащие этому конкретному пользователю", tags = {"User"})
public class UserController {



}

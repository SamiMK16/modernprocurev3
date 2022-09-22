package org.samiuelnegash.modernprocure.controllers;

import org.samiuelnegash.modernprocure.models.WebUserModel;
import org.samiuelnegash.modernprocure.security.AuthUserInfo;
import org.samiuelnegash.modernprocure.services.WebUserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class WebUserControlller {
    @NonNull
    private final WebUserService webUserService;

    @GetMapping("/list")
    public ResponseEntity<Page<WebUserModel>> get(@AuthenticationPrincipal AuthUserInfo user,
                                                  Pageable pageable) {
        return ResponseEntity.ok(webUserService.getAllUsers(user, true, pageable));
    }

    @PostMapping("auth/singup")
    private ResponseEntity<WebUserModel> signup(@RequestBody WebUserModel webUserModel) {
        return ResponseEntity.ok(webUserService.signup(webUserModel));
    }
}

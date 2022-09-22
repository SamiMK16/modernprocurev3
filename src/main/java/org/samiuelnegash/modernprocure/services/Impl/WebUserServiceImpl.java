package org.samiuelnegash.modernprocure.services.Impl;

import org.samiuelnegash.modernprocure.domain.WebUser;
import org.samiuelnegash.modernprocure.models.WebUserModel;
import org.samiuelnegash.modernprocure.repositories.WebUserRepository;
import org.samiuelnegash.modernprocure.security.AuthUserInfo;
import org.samiuelnegash.modernprocure.services.WebUserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import static org.samiuelnegash.modernprocure.specifications.WebUserSpecifications.withStatusActive;

@Service
@RequiredArgsConstructor
public class WebUserServiceImpl implements WebUserService {

    @NonNull
    private final WebUserRepository webUserRepository;

    @Override
    public Page<WebUserModel> getAllUsers(AuthUserInfo userInfo, Boolean active, Pageable pageable) {
        Specification<WebUser> webUserSpecification = Specification.where(withStatusActive(true));
        return webUserRepository.findAll(webUserSpecification, pageable).map(WebUserModel::new);
    }

    @Override
    public WebUserModel signup(WebUserModel webUserModel) {
        var webUser = new WebUser();
        webUser.setFirstName(webUserModel.getFirstName());
        webUser.setLastName(webUserModel.getLastName());
        webUser.setEmail(webUserModel.getEmail());
        webUser.setPassword("$2a$10$CkQY8PpSb2tvPHnAnXb3ju00RZec4ivvrfSilQLywJFs2PYqWqAu6");
        webUser.setActive(true);
        webUser.setPhoneNumber(webUserModel.getPhoneNumber());
        webUser.setStatus(WebUser.STATUS_ACTIVE);
        return new WebUserModel(webUserRepository.save(webUser));
    }

}

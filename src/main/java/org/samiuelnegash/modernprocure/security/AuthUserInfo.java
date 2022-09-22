package org.samiuelnegash.modernprocure.security;



import org.samiuelnegash.modernprocure.domain.WebUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.List;


public class AuthUserInfo implements UserDetails
{
    private final List<String> userRoles;
    private final Long webId;
    private final String name;
    private final String userName;
    private final String password;
    private final Boolean admin;

    public AuthUserInfo(WebUser webUser, List<String> userRoles, boolean admin)
    {
        this.userRoles = userRoles;
        this.admin = admin;
        this.webId = webUser.getWebId();
        this.userName = webUser.getEmail();
        this.name = webUser.getFirstName() + " " + webUser.getLastName();
        this.password = webUser.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        var roles = StringUtils.collectionToCommaDelimitedString(userRoles);
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    @Override
    public String getPassword()
    {
        return this.password;
    }

    @Override
    public String getUsername()
    {
        return this.userName;
    }

    public boolean isAdmin()
    {
        return admin;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }

    public List<String> getUserRoles()
    {
        return userRoles;
    }

    public Long getWebId()
    {
        return webId;
    }


    public String getName()
    {
        return name;
    }
}

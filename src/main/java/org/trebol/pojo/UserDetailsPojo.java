/*
 * Copyright (c) 2022 The Trebol eCommerce Project
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished
 * to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.trebol.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserDetailsPojo
    implements UserDetails {
  private static final long serialVersionUID = 1L;

  private final List<? extends GrantedAuthority> authorities;
  private final String username;
  private final String password;
  private final boolean accountNonExpired;
  private final boolean accountNonLocked;
  private final boolean credentialsNonExpired;
  private final boolean enabled;

  public UserDetailsPojo(List<? extends GrantedAuthority> authorities,
                         String username,
                         String password,
                         boolean accountNonExpired,
                         boolean accountNonLocked,
                         boolean credentialsNonExpired,
                         boolean enabled) {
    this.authorities = authorities;
    this.username = username;
    this.password = password;
    this.accountNonExpired = accountNonExpired;
    this.accountNonLocked = accountNonLocked;
    this.credentialsNonExpired = credentialsNonExpired;
    this.enabled = enabled;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    UserDetailsPojo that = (UserDetailsPojo) o;
    return accountNonExpired == that.accountNonExpired &&
        accountNonLocked == that.accountNonLocked &&
        credentialsNonExpired == that.credentialsNonExpired &&
        enabled == that.enabled &&
        Objects.equals(authorities, that.authorities) &&
        Objects.equals(username, that.username) &&
        Objects.equals(password, that.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(authorities, username, password, accountNonExpired, accountNonLocked, credentialsNonExpired,
        enabled);
  }

  @Override
  public String toString() {
    return "UserDetailsPojo{" +
        "authorities=" + authorities +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", accountNonExpired=" + accountNonExpired +
        ", accountNonLocked=" + accountNonLocked +
        ", credentialsNonExpired=" + credentialsNonExpired +
        ", enabled=" + enabled +
        '}';
  }
}

package com.seudjh.chatapplication.authenticationservice.data.user.common.updateAvatar;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UpdateAvatarRequest {

    public String avatarUrl;

}

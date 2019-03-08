package com.organOld.oService.service;

import com.organOld.dao.entity.Message;
import com.organOld.oService.contract.BTableRequest;
import com.organOld.oService.contract.Conse;
import com.organOld.oService.contract.MessageRequest;

public interface MessageService {
    Conse saveMessage(MessageRequest messageRequest);

    Conse saveRegMessage(Message message);

    void saveCartMessage(MessageRequest messageRequest);

    Conse getMessage(MessageRequest messageRequest);
}

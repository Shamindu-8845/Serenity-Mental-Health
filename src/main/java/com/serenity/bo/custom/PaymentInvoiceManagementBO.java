package com.serenity.bo.custom;

import com.serenity.bo.SuperBO;
import com.serenity.dto.PaymentsDTO;

import java.io.IOException;
import java.util.List;

public interface PaymentInvoiceManagementBO extends SuperBO {
    boolean savePayment(PaymentsDTO paymentsDTO) throws IOException;

    boolean updatePayment(PaymentsDTO paymentsDTO) throws IOException;

    String getlastId() throws IOException;

    boolean deletePayment(String text) throws IOException;

    List<PaymentsDTO> getAllPayments() throws IOException;

    List getAllPatientsId() throws IOException;

    List getAllTherapyId() throws IOException;
}

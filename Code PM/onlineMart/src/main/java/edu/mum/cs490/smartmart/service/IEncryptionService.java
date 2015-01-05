/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.service;

/**
 *
 * @author Komal
 */
public interface IEncryptionService {
    
    public  String getEncryptedPassword(String textPassword);
    public  String byteToString(byte[] input);
}

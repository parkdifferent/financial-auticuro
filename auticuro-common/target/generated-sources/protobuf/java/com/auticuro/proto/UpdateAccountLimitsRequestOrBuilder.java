// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wallet.proto

package com.auticuro.proto;

public interface UpdateAccountLimitsRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.auticuro.proto.UpdateAccountLimitsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string account_number = 1;</code>
   * @return The accountNumber.
   */
  java.lang.String getAccountNumber();
  /**
   * <code>string account_number = 1;</code>
   * @return The bytes for accountNumber.
   */
  com.google.protobuf.ByteString
      getAccountNumberBytes();

  /**
   * <code>string upper_limit = 2;</code>
   * @return The upperLimit.
   */
  java.lang.String getUpperLimit();
  /**
   * <code>string upper_limit = 2;</code>
   * @return The bytes for upperLimit.
   */
  com.google.protobuf.ByteString
      getUpperLimitBytes();

  /**
   * <code>string lower_limit = 3;</code>
   * @return The lowerLimit.
   */
  java.lang.String getLowerLimit();
  /**
   * <code>string lower_limit = 3;</code>
   * @return The bytes for lowerLimit.
   */
  com.google.protobuf.ByteString
      getLowerLimitBytes();
}
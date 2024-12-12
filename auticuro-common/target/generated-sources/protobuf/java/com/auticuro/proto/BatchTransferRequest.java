// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wallet.proto

package com.auticuro.proto;

/**
 * Protobuf type {@code com.auticuro.proto.BatchTransferRequest}
 */
public final class BatchTransferRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.auticuro.proto.BatchTransferRequest)
    BatchTransferRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use BatchTransferRequest.newBuilder() to construct.
  private BatchTransferRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private BatchTransferRequest() {
    batchId_ = "";
    transfers_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new BatchTransferRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.auticuro.proto.WalletProto.internal_static_com_auticuro_proto_BatchTransferRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.auticuro.proto.WalletProto.internal_static_com_auticuro_proto_BatchTransferRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.auticuro.proto.BatchTransferRequest.class, com.auticuro.proto.BatchTransferRequest.Builder.class);
  }

  public static final int BATCH_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object batchId_ = "";
  /**
   * <code>string batch_id = 1;</code>
   * @return The batchId.
   */
  @java.lang.Override
  public java.lang.String getBatchId() {
    java.lang.Object ref = batchId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      batchId_ = s;
      return s;
    }
  }
  /**
   * <code>string batch_id = 1;</code>
   * @return The bytes for batchId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getBatchIdBytes() {
    java.lang.Object ref = batchId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      batchId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TRANSFERS_FIELD_NUMBER = 2;
  @SuppressWarnings("serial")
  private java.util.List<com.auticuro.proto.TransferRequest> transfers_;
  /**
   * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
   */
  @java.lang.Override
  public java.util.List<com.auticuro.proto.TransferRequest> getTransfersList() {
    return transfers_;
  }
  /**
   * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.auticuro.proto.TransferRequestOrBuilder> 
      getTransfersOrBuilderList() {
    return transfers_;
  }
  /**
   * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
   */
  @java.lang.Override
  public int getTransfersCount() {
    return transfers_.size();
  }
  /**
   * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
   */
  @java.lang.Override
  public com.auticuro.proto.TransferRequest getTransfers(int index) {
    return transfers_.get(index);
  }
  /**
   * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
   */
  @java.lang.Override
  public com.auticuro.proto.TransferRequestOrBuilder getTransfersOrBuilder(
      int index) {
    return transfers_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(batchId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, batchId_);
    }
    for (int i = 0; i < transfers_.size(); i++) {
      output.writeMessage(2, transfers_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(batchId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, batchId_);
    }
    for (int i = 0; i < transfers_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, transfers_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.auticuro.proto.BatchTransferRequest)) {
      return super.equals(obj);
    }
    com.auticuro.proto.BatchTransferRequest other = (com.auticuro.proto.BatchTransferRequest) obj;

    if (!getBatchId()
        .equals(other.getBatchId())) return false;
    if (!getTransfersList()
        .equals(other.getTransfersList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + BATCH_ID_FIELD_NUMBER;
    hash = (53 * hash) + getBatchId().hashCode();
    if (getTransfersCount() > 0) {
      hash = (37 * hash) + TRANSFERS_FIELD_NUMBER;
      hash = (53 * hash) + getTransfersList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.auticuro.proto.BatchTransferRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.auticuro.proto.BatchTransferRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.auticuro.proto.BatchTransferRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.auticuro.proto.BatchTransferRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.auticuro.proto.BatchTransferRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.auticuro.proto.BatchTransferRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.auticuro.proto.BatchTransferRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.auticuro.proto.BatchTransferRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.auticuro.proto.BatchTransferRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.auticuro.proto.BatchTransferRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.auticuro.proto.BatchTransferRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.auticuro.proto.BatchTransferRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.auticuro.proto.BatchTransferRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.auticuro.proto.BatchTransferRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.auticuro.proto.BatchTransferRequest)
      com.auticuro.proto.BatchTransferRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.auticuro.proto.WalletProto.internal_static_com_auticuro_proto_BatchTransferRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.auticuro.proto.WalletProto.internal_static_com_auticuro_proto_BatchTransferRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.auticuro.proto.BatchTransferRequest.class, com.auticuro.proto.BatchTransferRequest.Builder.class);
    }

    // Construct using com.auticuro.proto.BatchTransferRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      batchId_ = "";
      if (transfersBuilder_ == null) {
        transfers_ = java.util.Collections.emptyList();
      } else {
        transfers_ = null;
        transfersBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000002);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.auticuro.proto.WalletProto.internal_static_com_auticuro_proto_BatchTransferRequest_descriptor;
    }

    @java.lang.Override
    public com.auticuro.proto.BatchTransferRequest getDefaultInstanceForType() {
      return com.auticuro.proto.BatchTransferRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.auticuro.proto.BatchTransferRequest build() {
      com.auticuro.proto.BatchTransferRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.auticuro.proto.BatchTransferRequest buildPartial() {
      com.auticuro.proto.BatchTransferRequest result = new com.auticuro.proto.BatchTransferRequest(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.auticuro.proto.BatchTransferRequest result) {
      if (transfersBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)) {
          transfers_ = java.util.Collections.unmodifiableList(transfers_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.transfers_ = transfers_;
      } else {
        result.transfers_ = transfersBuilder_.build();
      }
    }

    private void buildPartial0(com.auticuro.proto.BatchTransferRequest result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.batchId_ = batchId_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.auticuro.proto.BatchTransferRequest) {
        return mergeFrom((com.auticuro.proto.BatchTransferRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.auticuro.proto.BatchTransferRequest other) {
      if (other == com.auticuro.proto.BatchTransferRequest.getDefaultInstance()) return this;
      if (!other.getBatchId().isEmpty()) {
        batchId_ = other.batchId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (transfersBuilder_ == null) {
        if (!other.transfers_.isEmpty()) {
          if (transfers_.isEmpty()) {
            transfers_ = other.transfers_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureTransfersIsMutable();
            transfers_.addAll(other.transfers_);
          }
          onChanged();
        }
      } else {
        if (!other.transfers_.isEmpty()) {
          if (transfersBuilder_.isEmpty()) {
            transfersBuilder_.dispose();
            transfersBuilder_ = null;
            transfers_ = other.transfers_;
            bitField0_ = (bitField0_ & ~0x00000002);
            transfersBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getTransfersFieldBuilder() : null;
          } else {
            transfersBuilder_.addAllMessages(other.transfers_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              batchId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              com.auticuro.proto.TransferRequest m =
                  input.readMessage(
                      com.auticuro.proto.TransferRequest.parser(),
                      extensionRegistry);
              if (transfersBuilder_ == null) {
                ensureTransfersIsMutable();
                transfers_.add(m);
              } else {
                transfersBuilder_.addMessage(m);
              }
              break;
            } // case 18
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object batchId_ = "";
    /**
     * <code>string batch_id = 1;</code>
     * @return The batchId.
     */
    public java.lang.String getBatchId() {
      java.lang.Object ref = batchId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        batchId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string batch_id = 1;</code>
     * @return The bytes for batchId.
     */
    public com.google.protobuf.ByteString
        getBatchIdBytes() {
      java.lang.Object ref = batchId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        batchId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string batch_id = 1;</code>
     * @param value The batchId to set.
     * @return This builder for chaining.
     */
    public Builder setBatchId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      batchId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>string batch_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearBatchId() {
      batchId_ = getDefaultInstance().getBatchId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>string batch_id = 1;</code>
     * @param value The bytes for batchId to set.
     * @return This builder for chaining.
     */
    public Builder setBatchIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      batchId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.util.List<com.auticuro.proto.TransferRequest> transfers_ =
      java.util.Collections.emptyList();
    private void ensureTransfersIsMutable() {
      if (!((bitField0_ & 0x00000002) != 0)) {
        transfers_ = new java.util.ArrayList<com.auticuro.proto.TransferRequest>(transfers_);
        bitField0_ |= 0x00000002;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.auticuro.proto.TransferRequest, com.auticuro.proto.TransferRequest.Builder, com.auticuro.proto.TransferRequestOrBuilder> transfersBuilder_;

    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public java.util.List<com.auticuro.proto.TransferRequest> getTransfersList() {
      if (transfersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(transfers_);
      } else {
        return transfersBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public int getTransfersCount() {
      if (transfersBuilder_ == null) {
        return transfers_.size();
      } else {
        return transfersBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public com.auticuro.proto.TransferRequest getTransfers(int index) {
      if (transfersBuilder_ == null) {
        return transfers_.get(index);
      } else {
        return transfersBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public Builder setTransfers(
        int index, com.auticuro.proto.TransferRequest value) {
      if (transfersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTransfersIsMutable();
        transfers_.set(index, value);
        onChanged();
      } else {
        transfersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public Builder setTransfers(
        int index, com.auticuro.proto.TransferRequest.Builder builderForValue) {
      if (transfersBuilder_ == null) {
        ensureTransfersIsMutable();
        transfers_.set(index, builderForValue.build());
        onChanged();
      } else {
        transfersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public Builder addTransfers(com.auticuro.proto.TransferRequest value) {
      if (transfersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTransfersIsMutable();
        transfers_.add(value);
        onChanged();
      } else {
        transfersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public Builder addTransfers(
        int index, com.auticuro.proto.TransferRequest value) {
      if (transfersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTransfersIsMutable();
        transfers_.add(index, value);
        onChanged();
      } else {
        transfersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public Builder addTransfers(
        com.auticuro.proto.TransferRequest.Builder builderForValue) {
      if (transfersBuilder_ == null) {
        ensureTransfersIsMutable();
        transfers_.add(builderForValue.build());
        onChanged();
      } else {
        transfersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public Builder addTransfers(
        int index, com.auticuro.proto.TransferRequest.Builder builderForValue) {
      if (transfersBuilder_ == null) {
        ensureTransfersIsMutable();
        transfers_.add(index, builderForValue.build());
        onChanged();
      } else {
        transfersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public Builder addAllTransfers(
        java.lang.Iterable<? extends com.auticuro.proto.TransferRequest> values) {
      if (transfersBuilder_ == null) {
        ensureTransfersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, transfers_);
        onChanged();
      } else {
        transfersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public Builder clearTransfers() {
      if (transfersBuilder_ == null) {
        transfers_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
      } else {
        transfersBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public Builder removeTransfers(int index) {
      if (transfersBuilder_ == null) {
        ensureTransfersIsMutable();
        transfers_.remove(index);
        onChanged();
      } else {
        transfersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public com.auticuro.proto.TransferRequest.Builder getTransfersBuilder(
        int index) {
      return getTransfersFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public com.auticuro.proto.TransferRequestOrBuilder getTransfersOrBuilder(
        int index) {
      if (transfersBuilder_ == null) {
        return transfers_.get(index);  } else {
        return transfersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public java.util.List<? extends com.auticuro.proto.TransferRequestOrBuilder> 
         getTransfersOrBuilderList() {
      if (transfersBuilder_ != null) {
        return transfersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(transfers_);
      }
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public com.auticuro.proto.TransferRequest.Builder addTransfersBuilder() {
      return getTransfersFieldBuilder().addBuilder(
          com.auticuro.proto.TransferRequest.getDefaultInstance());
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public com.auticuro.proto.TransferRequest.Builder addTransfersBuilder(
        int index) {
      return getTransfersFieldBuilder().addBuilder(
          index, com.auticuro.proto.TransferRequest.getDefaultInstance());
    }
    /**
     * <code>repeated .com.auticuro.proto.TransferRequest transfers = 2;</code>
     */
    public java.util.List<com.auticuro.proto.TransferRequest.Builder> 
         getTransfersBuilderList() {
      return getTransfersFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.auticuro.proto.TransferRequest, com.auticuro.proto.TransferRequest.Builder, com.auticuro.proto.TransferRequestOrBuilder> 
        getTransfersFieldBuilder() {
      if (transfersBuilder_ == null) {
        transfersBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.auticuro.proto.TransferRequest, com.auticuro.proto.TransferRequest.Builder, com.auticuro.proto.TransferRequestOrBuilder>(
                transfers_,
                ((bitField0_ & 0x00000002) != 0),
                getParentForChildren(),
                isClean());
        transfers_ = null;
      }
      return transfersBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:com.auticuro.proto.BatchTransferRequest)
  }

  // @@protoc_insertion_point(class_scope:com.auticuro.proto.BatchTransferRequest)
  private static final com.auticuro.proto.BatchTransferRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.auticuro.proto.BatchTransferRequest();
  }

  public static com.auticuro.proto.BatchTransferRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<BatchTransferRequest>
      PARSER = new com.google.protobuf.AbstractParser<BatchTransferRequest>() {
    @java.lang.Override
    public BatchTransferRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<BatchTransferRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<BatchTransferRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.auticuro.proto.BatchTransferRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


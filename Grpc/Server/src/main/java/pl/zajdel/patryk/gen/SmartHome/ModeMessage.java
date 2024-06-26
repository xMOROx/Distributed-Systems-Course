// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: smarthome.proto

// Protobuf Java Version: 4.26.1
package pl.zajdel.patryk.gen.SmartHome;

/**
 * Protobuf type {@code SmartHome.ModeMessage}
 */
public final class ModeMessage extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:SmartHome.ModeMessage)
    ModeMessageOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      ModeMessage.class.getName());
  }
  // Use ModeMessage.newBuilder() to construct.
  private ModeMessage(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private ModeMessage() {
    mode_ = 0;
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_ModeMessage_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_ModeMessage_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            pl.zajdel.patryk.gen.SmartHome.ModeMessage.class, pl.zajdel.patryk.gen.SmartHome.ModeMessage.Builder.class);
  }

  public static final int MODE_FIELD_NUMBER = 1;
  private int mode_ = 0;
  /**
   * <code>.SmartHome.Mode mode = 1;</code>
   * @return The enum numeric value on the wire for mode.
   */
  @java.lang.Override public int getModeValue() {
    return mode_;
  }
  /**
   * <code>.SmartHome.Mode mode = 1;</code>
   * @return The mode.
   */
  @java.lang.Override public pl.zajdel.patryk.gen.SmartHome.Mode getMode() {
    pl.zajdel.patryk.gen.SmartHome.Mode result = pl.zajdel.patryk.gen.SmartHome.Mode.forNumber(mode_);
    return result == null ? pl.zajdel.patryk.gen.SmartHome.Mode.UNRECOGNIZED : result;
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
    if (mode_ != pl.zajdel.patryk.gen.SmartHome.Mode.ON.getNumber()) {
      output.writeEnum(1, mode_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (mode_ != pl.zajdel.patryk.gen.SmartHome.Mode.ON.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(1, mode_);
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
    if (!(obj instanceof pl.zajdel.patryk.gen.SmartHome.ModeMessage)) {
      return super.equals(obj);
    }
    pl.zajdel.patryk.gen.SmartHome.ModeMessage other = (pl.zajdel.patryk.gen.SmartHome.ModeMessage) obj;

    if (mode_ != other.mode_) return false;
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
    hash = (37 * hash) + MODE_FIELD_NUMBER;
    hash = (53 * hash) + mode_;
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static pl.zajdel.patryk.gen.SmartHome.ModeMessage parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pl.zajdel.patryk.gen.SmartHome.ModeMessage parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pl.zajdel.patryk.gen.SmartHome.ModeMessage parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pl.zajdel.patryk.gen.SmartHome.ModeMessage parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pl.zajdel.patryk.gen.SmartHome.ModeMessage parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pl.zajdel.patryk.gen.SmartHome.ModeMessage parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pl.zajdel.patryk.gen.SmartHome.ModeMessage parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static pl.zajdel.patryk.gen.SmartHome.ModeMessage parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static pl.zajdel.patryk.gen.SmartHome.ModeMessage parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static pl.zajdel.patryk.gen.SmartHome.ModeMessage parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static pl.zajdel.patryk.gen.SmartHome.ModeMessage parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static pl.zajdel.patryk.gen.SmartHome.ModeMessage parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(pl.zajdel.patryk.gen.SmartHome.ModeMessage prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code SmartHome.ModeMessage}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:SmartHome.ModeMessage)
      pl.zajdel.patryk.gen.SmartHome.ModeMessageOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_ModeMessage_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_ModeMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              pl.zajdel.patryk.gen.SmartHome.ModeMessage.class, pl.zajdel.patryk.gen.SmartHome.ModeMessage.Builder.class);
    }

    // Construct using pl.zajdel.patryk.gen.SmartHome.ModeMessage.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      mode_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_ModeMessage_descriptor;
    }

    @java.lang.Override
    public pl.zajdel.patryk.gen.SmartHome.ModeMessage getDefaultInstanceForType() {
      return pl.zajdel.patryk.gen.SmartHome.ModeMessage.getDefaultInstance();
    }

    @java.lang.Override
    public pl.zajdel.patryk.gen.SmartHome.ModeMessage build() {
      pl.zajdel.patryk.gen.SmartHome.ModeMessage result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public pl.zajdel.patryk.gen.SmartHome.ModeMessage buildPartial() {
      pl.zajdel.patryk.gen.SmartHome.ModeMessage result = new pl.zajdel.patryk.gen.SmartHome.ModeMessage(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(pl.zajdel.patryk.gen.SmartHome.ModeMessage result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.mode_ = mode_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof pl.zajdel.patryk.gen.SmartHome.ModeMessage) {
        return mergeFrom((pl.zajdel.patryk.gen.SmartHome.ModeMessage)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(pl.zajdel.patryk.gen.SmartHome.ModeMessage other) {
      if (other == pl.zajdel.patryk.gen.SmartHome.ModeMessage.getDefaultInstance()) return this;
      if (other.mode_ != 0) {
        setModeValue(other.getModeValue());
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
            case 8: {
              mode_ = input.readEnum();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
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

    private int mode_ = 0;
    /**
     * <code>.SmartHome.Mode mode = 1;</code>
     * @return The enum numeric value on the wire for mode.
     */
    @java.lang.Override public int getModeValue() {
      return mode_;
    }
    /**
     * <code>.SmartHome.Mode mode = 1;</code>
     * @param value The enum numeric value on the wire for mode to set.
     * @return This builder for chaining.
     */
    public Builder setModeValue(int value) {
      mode_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.SmartHome.Mode mode = 1;</code>
     * @return The mode.
     */
    @java.lang.Override
    public pl.zajdel.patryk.gen.SmartHome.Mode getMode() {
      pl.zajdel.patryk.gen.SmartHome.Mode result = pl.zajdel.patryk.gen.SmartHome.Mode.forNumber(mode_);
      return result == null ? pl.zajdel.patryk.gen.SmartHome.Mode.UNRECOGNIZED : result;
    }
    /**
     * <code>.SmartHome.Mode mode = 1;</code>
     * @param value The mode to set.
     * @return This builder for chaining.
     */
    public Builder setMode(pl.zajdel.patryk.gen.SmartHome.Mode value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      mode_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.SmartHome.Mode mode = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearMode() {
      bitField0_ = (bitField0_ & ~0x00000001);
      mode_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:SmartHome.ModeMessage)
  }

  // @@protoc_insertion_point(class_scope:SmartHome.ModeMessage)
  private static final pl.zajdel.patryk.gen.SmartHome.ModeMessage DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new pl.zajdel.patryk.gen.SmartHome.ModeMessage();
  }

  public static pl.zajdel.patryk.gen.SmartHome.ModeMessage getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ModeMessage>
      PARSER = new com.google.protobuf.AbstractParser<ModeMessage>() {
    @java.lang.Override
    public ModeMessage parsePartialFrom(
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

  public static com.google.protobuf.Parser<ModeMessage> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ModeMessage> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public pl.zajdel.patryk.gen.SmartHome.ModeMessage getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


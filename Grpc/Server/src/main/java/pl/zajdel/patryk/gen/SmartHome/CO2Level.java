// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: smarthome.proto

// Protobuf Java Version: 4.26.1
package pl.zajdel.patryk.gen.SmartHome;

/**
 * Protobuf type {@code SmartHome.CO2Level}
 */
public final class CO2Level extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:SmartHome.CO2Level)
    CO2LevelOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      CO2Level.class.getName());
  }
  // Use CO2Level.newBuilder() to construct.
  private CO2Level(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private CO2Level() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_CO2Level_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_CO2Level_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            pl.zajdel.patryk.gen.SmartHome.CO2Level.class, pl.zajdel.patryk.gen.SmartHome.CO2Level.Builder.class);
  }

  public static final int PPM_FIELD_NUMBER = 1;
  private int ppm_ = 0;
  /**
   * <code>int32 ppm = 1;</code>
   * @return The ppm.
   */
  @java.lang.Override
  public int getPpm() {
    return ppm_;
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
    if (ppm_ != 0) {
      output.writeInt32(1, ppm_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (ppm_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, ppm_);
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
    if (!(obj instanceof pl.zajdel.patryk.gen.SmartHome.CO2Level)) {
      return super.equals(obj);
    }
    pl.zajdel.patryk.gen.SmartHome.CO2Level other = (pl.zajdel.patryk.gen.SmartHome.CO2Level) obj;

    if (getPpm()
        != other.getPpm()) return false;
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
    hash = (37 * hash) + PPM_FIELD_NUMBER;
    hash = (53 * hash) + getPpm();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static pl.zajdel.patryk.gen.SmartHome.CO2Level parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pl.zajdel.patryk.gen.SmartHome.CO2Level parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pl.zajdel.patryk.gen.SmartHome.CO2Level parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pl.zajdel.patryk.gen.SmartHome.CO2Level parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pl.zajdel.patryk.gen.SmartHome.CO2Level parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pl.zajdel.patryk.gen.SmartHome.CO2Level parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pl.zajdel.patryk.gen.SmartHome.CO2Level parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static pl.zajdel.patryk.gen.SmartHome.CO2Level parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static pl.zajdel.patryk.gen.SmartHome.CO2Level parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static pl.zajdel.patryk.gen.SmartHome.CO2Level parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static pl.zajdel.patryk.gen.SmartHome.CO2Level parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static pl.zajdel.patryk.gen.SmartHome.CO2Level parseFrom(
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
  public static Builder newBuilder(pl.zajdel.patryk.gen.SmartHome.CO2Level prototype) {
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
   * Protobuf type {@code SmartHome.CO2Level}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:SmartHome.CO2Level)
      pl.zajdel.patryk.gen.SmartHome.CO2LevelOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_CO2Level_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_CO2Level_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              pl.zajdel.patryk.gen.SmartHome.CO2Level.class, pl.zajdel.patryk.gen.SmartHome.CO2Level.Builder.class);
    }

    // Construct using pl.zajdel.patryk.gen.SmartHome.CO2Level.newBuilder()
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
      ppm_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_CO2Level_descriptor;
    }

    @java.lang.Override
    public pl.zajdel.patryk.gen.SmartHome.CO2Level getDefaultInstanceForType() {
      return pl.zajdel.patryk.gen.SmartHome.CO2Level.getDefaultInstance();
    }

    @java.lang.Override
    public pl.zajdel.patryk.gen.SmartHome.CO2Level build() {
      pl.zajdel.patryk.gen.SmartHome.CO2Level result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public pl.zajdel.patryk.gen.SmartHome.CO2Level buildPartial() {
      pl.zajdel.patryk.gen.SmartHome.CO2Level result = new pl.zajdel.patryk.gen.SmartHome.CO2Level(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(pl.zajdel.patryk.gen.SmartHome.CO2Level result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.ppm_ = ppm_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof pl.zajdel.patryk.gen.SmartHome.CO2Level) {
        return mergeFrom((pl.zajdel.patryk.gen.SmartHome.CO2Level)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(pl.zajdel.patryk.gen.SmartHome.CO2Level other) {
      if (other == pl.zajdel.patryk.gen.SmartHome.CO2Level.getDefaultInstance()) return this;
      if (other.getPpm() != 0) {
        setPpm(other.getPpm());
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
              ppm_ = input.readInt32();
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

    private int ppm_ ;
    /**
     * <code>int32 ppm = 1;</code>
     * @return The ppm.
     */
    @java.lang.Override
    public int getPpm() {
      return ppm_;
    }
    /**
     * <code>int32 ppm = 1;</code>
     * @param value The ppm to set.
     * @return This builder for chaining.
     */
    public Builder setPpm(int value) {

      ppm_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 ppm = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPpm() {
      bitField0_ = (bitField0_ & ~0x00000001);
      ppm_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:SmartHome.CO2Level)
  }

  // @@protoc_insertion_point(class_scope:SmartHome.CO2Level)
  private static final pl.zajdel.patryk.gen.SmartHome.CO2Level DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new pl.zajdel.patryk.gen.SmartHome.CO2Level();
  }

  public static pl.zajdel.patryk.gen.SmartHome.CO2Level getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CO2Level>
      PARSER = new com.google.protobuf.AbstractParser<CO2Level>() {
    @java.lang.Override
    public CO2Level parsePartialFrom(
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

  public static com.google.protobuf.Parser<CO2Level> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CO2Level> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public pl.zajdel.patryk.gen.SmartHome.CO2Level getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: smarthome.proto

// Protobuf Java Version: 4.26.1
package pl.zajdel.patryk.gen.SmartHome;

/**
 * Protobuf type {@code SmartHome.FridgeRemoveShopping}
 */
public final class FridgeRemoveShopping extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:SmartHome.FridgeRemoveShopping)
    FridgeRemoveShoppingOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      FridgeRemoveShopping.class.getName());
  }
  // Use FridgeRemoveShopping.newBuilder() to construct.
  private FridgeRemoveShopping(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private FridgeRemoveShopping() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_FridgeRemoveShopping_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_FridgeRemoveShopping_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping.class, pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private int id_ = 0;
  /**
   * <code>int32 id = 1;</code>
   * @return The id.
   */
  @java.lang.Override
  public int getId() {
    return id_;
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
    if (id_ != 0) {
      output.writeInt32(1, id_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, id_);
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
    if (!(obj instanceof pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping)) {
      return super.equals(obj);
    }
    pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping other = (pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping) obj;

    if (getId()
        != other.getId()) return false;
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
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping parseFrom(
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
  public static Builder newBuilder(pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping prototype) {
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
   * Protobuf type {@code SmartHome.FridgeRemoveShopping}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:SmartHome.FridgeRemoveShopping)
      pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShoppingOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_FridgeRemoveShopping_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_FridgeRemoveShopping_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping.class, pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping.Builder.class);
    }

    // Construct using pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping.newBuilder()
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
      id_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return pl.zajdel.patryk.gen.SmartHome.Smarthome.internal_static_SmartHome_FridgeRemoveShopping_descriptor;
    }

    @java.lang.Override
    public pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping getDefaultInstanceForType() {
      return pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping.getDefaultInstance();
    }

    @java.lang.Override
    public pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping build() {
      pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping buildPartial() {
      pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping result = new pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.id_ = id_;
      }
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping) {
        return mergeFrom((pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping other) {
      if (other == pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping.getDefaultInstance()) return this;
      if (other.getId() != 0) {
        setId(other.getId());
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
              id_ = input.readInt32();
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

    private int id_ ;
    /**
     * <code>int32 id = 1;</code>
     * @return The id.
     */
    @java.lang.Override
    public int getId() {
      return id_;
    }
    /**
     * <code>int32 id = 1;</code>
     * @param value The id to set.
     * @return This builder for chaining.
     */
    public Builder setId(int value) {

      id_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearId() {
      bitField0_ = (bitField0_ & ~0x00000001);
      id_ = 0;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:SmartHome.FridgeRemoveShopping)
  }

  // @@protoc_insertion_point(class_scope:SmartHome.FridgeRemoveShopping)
  private static final pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping();
  }

  public static pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<FridgeRemoveShopping>
      PARSER = new com.google.protobuf.AbstractParser<FridgeRemoveShopping>() {
    @java.lang.Override
    public FridgeRemoveShopping parsePartialFrom(
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

  public static com.google.protobuf.Parser<FridgeRemoveShopping> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<FridgeRemoveShopping> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public pl.zajdel.patryk.gen.SmartHome.FridgeRemoveShopping getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


package springfox.documentation.schema;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class ModelSpecification {
  private ScalarModelSpecification scalar;
  private CompoundModelSpecification compound;
  private CollectionSpecification collection;
  private MapSpecification map;
  private ReferenceModelSpecification reference;
  private String name;
  private String namespace;
  private ModelFacets facets;

  @SuppressWarnings("ParameterNumber")
  public ModelSpecification(
      String namespace,
      String name,
      ModelFacets facets,
      ScalarModelSpecification scalar,
      CompoundModelSpecification compound,
      CollectionSpecification collection,
      MapSpecification map,
      ReferenceModelSpecification reference) {
    ensureValidSpecification(scalar, compound, reference, collection, map);
    this.namespace = namespace;
    this.collection = collection;
    this.facets = facets;
    this.map = map;
    this.name = name;
    this.scalar = scalar;
    this.compound = compound;
    this.reference = reference;
  }

  public String getNamespace() {
    return namespace;
  }

  public String getName() {
    return name;
  }

  public Optional<ScalarModelSpecification> getScalar() {
    return Optional.ofNullable(scalar);
  }

  public Optional<CompoundModelSpecification> getCompound() {
    return Optional.ofNullable(compound);
  }

  public Optional<CollectionSpecification> getCollection() {
    return Optional.ofNullable(collection);
  }

  public Optional<MapSpecification> getMap() {
    return Optional.ofNullable(map);
  }

  public Optional<ReferenceModelSpecification> getReference() {
    return Optional.ofNullable(reference);
  }

  public ModelFacets getFacets() {
    return facets;
  }

  private void ensureValidSpecification(
      Object... specs) {
    long specCount = Arrays.stream(specs)
        .filter(Objects::nonNull)
        .count();
    if (specCount != 1) {
      throw new IllegalArgumentException("Only one of the specifications should be non null");
    }
  }
}
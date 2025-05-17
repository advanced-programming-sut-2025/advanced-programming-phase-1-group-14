package org.example.Model.tools;

public class Tool {
    String name;
    ToolType type;
    ToolMaterial material;

    public Tool(ToolType type, ToolMaterial initial) {
        this.name = type.name();
        this.type = type;
        this.material = ToolMaterial.Initial;
    }

    public ToolType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public ToolMaterial getMaterial() {
        return material;
    }

    public void upgrade(ToolMaterial material) {
        this.material = material;
    }

    public Tool copy() {
        Tool copy = new Tool(this.type, ToolMaterial.Initial);
        copy.upgrade(this.material);
        return copy;
    }

    @Override
    public String toString() {
        return name;
    }
}
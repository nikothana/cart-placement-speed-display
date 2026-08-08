<center># 💣 Cart Placement Speed Display</center>

![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21%2B-brightgreen)
![Fabric API](https://img.shields.io/badge/Mod%20Loader-Fabric-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

A lightweight Minecraft Fabric mod designed for **Crossbow CartPVP** enthusiasts. It tracks and displays your frame timing directly on your action bar with customizable gradient colors.

---

## ✨ Features

* ⏱️ **Frame-Accurate Tracking**: Automatically tracks sequence timing from placing rails, minecarts, and flint & steel to firing a loaded crossbow.
* 🎨 **Dynamic Color Gradients**: Customizable gradient text for the frame output across all 16 Minecraft colors.
* ⚙️ **In-Game Mod Configuration**: Seamless integration with **Mod Menu** and **Cloth Config API** for on-the-fly toggling and customization.
* 📦 **Zero-Dependency Setup**: Bundled with Cloth Config API out of the box—no extra mod downloads required!

---

## 📸 Screenshots & Usage

Once enabled, perform your CartPVP sequence:
1. Place a **Rail**
2. Place a **TNT Minecart**
3. Ignite with **Flint and Steel**
4. Shoot your **Crossbow**

Your frame count will display instantly on your action bar:

> **Cart Placement Speed:** <span style="color:#e066ff;">**12 Frames**</span>

---

## 🎨 Available Color Presets

You can select from any of the standard Minecraft formatting colors in the config menu. Each option dynamically scales into a gradient:

| Color Palette | Gradient Example |
| :--- | :--- |
| **Light Purple** *(Default)* | Light Purple ➔ Dark Purple |
| **Aqua** | Bright Aqua ➔ Dark Aqua |
| **Gold** | Bright Gold ➔ Deep Orange |
| **Green** | Bright Green ➔ Dark Green |
| **Red** | Light Red ➔ Dark Red |
| **White** | Crisp White ➔ Medium Gray |
| *...and 10 more!* | *All 16 Minecraft formatting colors supported* |

---

## 🔧 Installation

1. Download the latest `.jar` from the **Releases** tab.
2. Make sure you have **[Fabric Loader](https://fabricmc.net/)** and **[Fabric API](https://modrinth.com/mod/fabric-api)** installed.
3. Drop the downloaded `.jar` file into your `.minecraft/mods` folder.
4. *(Optional)* Install **[Mod Menu](https://modrinth.com/mod/modmenu)** to customize settings in-game.

---

## 📋 Compatibility

| Dependency | Supported Version |
| :--- | :--- |
| **Minecraft** | `>= 1.21` (Tested up to `1.21.11`) |
| **Fabric Loader** | `>= 0.16.0` |
| **Java** | `Java 21` |

---

## 🔨 Building from Source

To build the project locally, clone the repository and run:

```bash
git clone [https://github.com/your-username/cart-placement-speed-display.git](https://github.com/your-username/cart-placement-speed-display.git)
cd cart-placement-speed-display
./gradlew build

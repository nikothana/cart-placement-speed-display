<div align="center">

# 💣 Cart Placement Speed Display 1.1.4

![Minecraft Version](https://img.shields.io/badge/Minecraft-1.21%2B-brightgreen)
![Mod Loader](https://img.shields.io/badge/Mod%20Loader-Fabric-blue)
![Cloth Config](https://img.shields.io/badge/Cloth%20Config-Bundled-purple)
![License](https://img.shields.io/badge/License-MIT-yellow)

A lightweight Minecraft Fabric mod designed for **Crossbow CartPVP** enthusiasts. It tracks and displays your frame timing directly on your action bar with customizable gradient colors and in-depth performance statistics.

</div>

---

## ✨ Features

* ⏱️ **Frame-Accurate Tracking**: Automatically tracks sequence timing from placing rails, minecarts, and flint & steel to firing a loaded crossbow.
* 📈 **In-Game Statistics**: Track your total combos, session performance, fastest/slowest runs, average speed, and sub-10 frame executions directly inside Mod Menu.
* 🎨 **Dynamic Color Gradients**: Customizable gradient text for the frame output across all 16 Minecraft colors.
* ⚙️ **In-Game Mod Configuration**: Seamless integration with **Mod Menu** and **Cloth Config API** for on-the-fly toggling and customization.
* 📦 **Zero-Dependency Setup**: Bundled with Cloth Config API out of the box—no extra mod downloads required!

---

## 📝 Usage

Once enabled, perform your CartPVP sequence:
1. Place a **Rail**
2. Place a **TNT Minecart**
3. Ignite with **Flint and Steel**
4. Shoot your **Crossbow**

Your frame count will display instantly on your action bar:

> **Cart Placement Speed:** <span style="color:#e066ff;">**12 Frames**</span>

---

## 📊 Tracked Statistics

Head over to the **Statistics** tab in the Mod Menu config to view:

| Metric | Description |
| :--- | :--- |
| **Total Combos** | Lifetime record of completed CartPVP sequences |
| **Session Combos** | Combos executed during your current game session |
| **Fastest / Slowest** | Best and worst recorded frame timings |
| **Average Cart Speed** | Live rolling average speed across all runs |
| **Sub-10 Frame Combos** | Count of ultra-fast combos executed in $\le 10$ frames |

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

1. Download **`cart-placement-speed-display-1.1.4+1.21.11.jar`** from the **Releases** tab.
2. Make sure you have **[Fabric Loader](https://fabricmc.net/)** (`>=0.19.3`) and **[Fabric API](https://modrinth.com/mod/fabric-api)** installed.
3. Drop the downloaded `.jar` file into your `.minecraft/mods` folder.
4. *(Optional)* Install **[Mod Menu](https://modrinth.com/mod/modmenu)** to view your statistics and customize settings in-game.

---

## 📋 Compatibility

| Component | Version Requirement |
| :--- | :--- |
| **Minecraft** | `>= 1.21` (Tested up to `1.21.11`) |
| **Fabric Loader** | `>= 0.19.3` |
| **Java** | `>= 21` |
| **Cloth Config API** | Bundled |

Yin-Yang
===

[![Build Status](https://travis-ci.org/Naoghuman/app-yin-yang.svg?branch=master)](https://travis-ci.org/Naoghuman/app-yin-yang)
[![license: GPL v3](https://img.shields.io/badge/License-GPL%20v3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)
[![GitHub release](https://img.shields.io/github/release/Naoghuman/app-yin-yang.svg)](https://GitHub.com/Naoghuman/app-yin-yang/releases/)



Intention
---

The app Yin-Yang is a little [JavaFX] &amp; [Maven] desktop application which 
demonstrate some nice JavaFX features like borderless application, multilingualism, 
animations aso..

_Image:_ Some snapshots  
![Intention_Screenshoot_v0.8.0_2018-11-25_07-59.png][Intention_Screenshoot_v0.8.0_2018-11-25_07-59]


Content
---

* [Screenshots](#Screenshots)
* [Features](#Features)
    - [Borderless transparent application](#BordTranAppl)
    - [Multilingualism application](#MultAppl)
    - [Always on top](#AlwaOnTop)
    - [Animations](#Anim)
    - [Action event handling](#ActiEvenHand)
    - [Simple data storage](#SimpDataStor)
* [Contribution](#Contribution)
* [Installation](#Installation)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Features<a name="Features" />
---

TODO


### Borderless transparent application<a name="BordTranAppl" />

In [JavaFX] it's really simple to create a borderless application with transparent 
background color.

In the first step the background color from the [Scene] needs to set to `transparent`.
```java
@Override
public void start(Stage primaryStage) throws Exception {
    ...
    final Scene scene = new Scene(view.getView(), 330.0d, 330.0d);
    scene.setFill(Color.TRANSPARENT);
    ...
}
```

In the second step the `style` from the [Stage] need to be adjusted.
```java
@Override
public void start(Stage primaryStage) throws Exception {
    ...
    // Defines a normal Stage style with a solid white background and platform decorations.
    stage.initStyle(StageStyle.DECORATED);

    // Defines a Stage style with a solid white background and no decorations.
    stage.initStyle(StageStyle.UNDECORATED);

    // Defines a Stage style with a transparent background and no decorations.
    stage.initStyle(StageStyle.TRANSPARENT);
    ...
}
```

_Image:_ Demonstration from different [StageStyle]s
_From left to right: `decorated`, `undecorated`, `transparent`_  
![StageStyles_v0.9.0_2018-11-28_22-13.png][StageStyles_v0.9.0_2018-11-28_22-13]


### Multilingualism application<a name="MultAppl" />

TODO


### Always on top<a name="AlwaOnTop" />

TODO



### Animations<a name="Anim" />

TODO


### Action event handling<a name="ActiEvenHand" />

TODO


### Simple data storage<a name="SimpDataStor" />

TODO



Installation<a name="Installation" />
---

* If not installed download minimal [JRE 8] or the [JDK 8].
* Download the file [yin-yang-0.1.0.zip].
* Extract the file to a place your choice.
* To start the application double click the jar file 'yin-yang-0.1.0.jar' in 
  the extracted folder.



Contribution<a name="Contribution" />
---

* If you find a `Bug` I will be glad if you could report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



License<a name="License" />
---

The project `Yin-Yang` is licensed under [General Public License 3.0].



Autor<a name="Autor" />
---

The project `Yin-Yang` is maintained by me, Peter Rogge. See [Contact](#Contact).



Contact<a name="Contact" />
---

You can reach me under <peter.rogge@yahoo.de>.



[//]: # (Images)
[Intention_Screenshoot_v0.8.0_2018-11-25_07-59]:https://user-images.githubusercontent.com/8161815/48976441-11d21800-f088-11e8-9be8-9b685211b1a5.png
[StageStyles_v0.9.0_2018-11-28_22-13]:https://user-images.githubusercontent.com/8161815/49182549-e0dd3600-f35a-11e8-8373-27bf6ca8fe5e.png



[//]: # (Links)
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[Issue]:https://github.com/Naoghuman/yin-yang/issues
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Maven]:http://maven.apache.org/
[Pull Request]:https://help.github.com/articles/using-pull-requests
[Scene]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Scene.html
[Stage]:https://docs.oracle.com/javase/8/javafx/api/javafx/stage/Stage.html
[StageStyle]:https://docs.oracle.com/javase/8/javafx/api/javafx/stage/StageStyle.html
[yin-yang-0.1.0.zip]:https://github.com/Naoghuman/app-yin-yang/releases/tag/v0.1.0

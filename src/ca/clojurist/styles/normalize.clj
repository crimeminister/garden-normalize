(ns ca.clojurist.styles.normalize
  "A Garden port of Normalize.css."
  (:require
   [garden.selectors :refer [attr attr= abbr audio button defpseudoclass defpseudoelement html not svg]]
   [garden.units :refer [em px percent]]))

(defpseudoclass -moz-focusring)
(defpseudoelement -moz-focus-inner)
(defpseudoelement -webkit-file-upload-button)
(defpseudoelement -webkit-inner-spin-button)
(defpseudoelement -webkit-outer-spin-button)
(defpseudoelement -webkit-search-cancel-button)
(defpseudoelement -webkit-search-decoration)

(def document
  [:html {;; Change the default font family in all browsers (opinionated).
          :font-family "sans-serif"
          ;; Correct the line height in all browsers.
          :line-height 1.15
          ;; Prevent adjustments of font size after orientation changes
          ;; in IE on Windows Phone and in iOS.
          :-ms-text-size-adjust (percent 100)
          :-webkit-text-size-adjust (percent 100)}])

(def sections
  [;; Remove the margin in all browsers (opinionated).
   [:body {:margin 0}]
   ;; Add the correct display in IE 9-.
   [:article
    :aside
    :footer
    :header
    :nav
    :section {:display :block}]
   ;; Correct the font size and margin on `h1` elements within `section`
   ;; and `article` contexts in Chrome, Firefox, and Safari.
   [:h1 {:font-size (em 2)
         :margin [[(em 0.67) 0]]}]])

(def grouping
  [;; Add the correct display in IE 9-.
   [:figcaption :figure :main {:display :block}]
   ;; Add the correct margin in IE 8.
   [:figure {:margin [[(em 1) (px 40)]]}]
   [:hr (merge
         ;; Add the correct box sizing in Firefox.
         {:box-sizing :content-box
          :height 0}
         ;; Show the overflow in Edge and IE.
         {:overflow :visible})]
   [:pre {;; Correct the inheritance and scaling of font size in all browsers.
         :font-family [:monospace :monospace]
         ;; Correct the odd `em` font sizing in all browsers.
         :font-size (em 1)}]])

(def text
  [[:a {;; Remove the gray background on active links in IE 10.
        :background-color :transparent
        ;; Remove gaps in links underline in iOS 8+ and Safari 8+.
        :-webkit-text-decoration-skip :objects}]
   ;; Remove the outline on focused links when they are also active or
   ;; hovered in all browsers (opinionated).
   [:a:active
    :a:hover {:outline-width 0}]

   [(abbr (attr :title)) {;; Remove the bottom border in Firefox 39-.
                          :border-bottom :none}]
   ;; Add the correct text decoration in Chrome, Edge, IE, Opera, and Safari.
   ;; NB: The rules below are duplicated because including both of these
   ;; styles in the same map results in a key collision.
   [(abbr (attr :title)) {:text-decoration :underline}]
   [(abbr (attr :title)) {:text-decoration [[:underline :dotted]]}]
   ;; Prevent the duplicate application of `bolder` by the next rule in Safari 6.
   [:b :strong {:font-weight :inherit}]
   ;; Add the correct font weight in Chrome, Edge, and Safari.
   [:b :strong {:font-weight :bolder}]
   [:code :kbd :samp {;; Correct the inheritance and scaling of font size in all browsers.
                      :font-family [:monospace :monospace]
                      ;; Correct the odd `em` font sizing in all browsers.
                      :font-size (em 1)}]
   ;; Add the correct font style in Android 4.3-.
   [:dfn {:font-style :italic}]
   ;; Add the correct background and color in IE 9-.
   [:mark {:background-color "#ff0"
           :color "#000"}]
   ;; Add the correct font size in all browsers.
   [:small {:font-size (percent 80)}]
   ;; Prevent `sub` and `sup` elements from affecting the line height in all browsers.
   [:sub :sup {:font-size (percent 75)
               :line-height 0
               :position :relative
               :vertical-align :baseline}]
   [:sub {:bottom (em -0.25)}]
   [:sup {:top (em -0.5)}]])

(def embedded
  "Embedded content."
  [;; Add the correct display in IE 9-.
   [:audio
    :video {:display :inline-block}]
   ;; Add the correct display in iOS 4-7.
   [(audio (not (attr :controls))) {:display :none
                                    :height 0}]
   ;; Remove the border on images inside links in IE 10-.
   [:img {:border-style :none}]
   ;; Hide the overflow in IE.
   [(svg (not ":root")) {:overflow :hidden}]])

(def forms
  "Forms."
  [[:button
    :input
    :optgroup
    :select
    :textarea
    (merge
     ;; Change the font styles in all browsers (opinionated).
     {:font-family :sans-serif
      :font-size (percent 100)
      :line-height 1.15}
     ;; Remove the margin in Firefox and Safari.
     {:margin 0})]
   ;; Show the overflow in IE (Edge).
   [:button
    :input {:overflow :visible}]
   ;; Remove the inheritance of text transform in Edge, Firefox, and IE.
   [:button
    :select {:text-transform :none}]
   [:button
    ;; Prevent a WebKit bug where (2) destroys native `audio` and `video` controls in Android 4.
    (html (attr= :type :button))
    (attr= :type :reset)
    (attr= :type :submit)
    {;; Correct the inability to style clickable types in iOS and Safari.
     :-webkit-appearance :button}]
   ;; Remove the inner border and padding in Firefox.
   [(button -moz-focus-inner)
    ((attr= :type "button") -moz-focus-inner)
    ((attr= :type "reset") -moz-focus-inner)
    ((attr= :type "submit") -moz-focus-inner)
    {:border-style :none
     :padding 0}]
   ;; Restore the focus styles unset by the previous rule.
   [:button:-moz-focusring
    ((attr= :type "button") -moz-focusring)
    ((attr= :type "reset") -moz-focusring)
    ((attr= :type "submit") -moz-focusring)
    {:outline [[(px 1) :dotted :ButtonText]]}]
   ;; Change the border, margin, and padding in all browsers (opinionated).
   [:fieldset {:border [[(px 1) :solid :#c0c0c0]]
               :margin [[0 (px 2)]]
               :padding [[(em 0.35) (em 0.625) (em 0.75)]]}]
   [:legend {;; Correct the text wrapping in Edge and IE.
             :box-sizing :border-box
             ;; Correct the color inheritance from `fieldset` elements in IE.
             :color :inherit
             :display :table
             :max-width (percent 100)
             ;; Remove the padding so developers are not caught out when
             ;; they zero out `fieldset` elements in all browsers.
             :padding 0
             ;; Correct the color inheritance from `fieldset` elements in IE.
             :white-space :normal}]
   [:progress {;; Add the correct display in IE 9-.
               :display :inline-block
               ;; Add the correct vertical alignment in Chrome, Firefox, and Opera.
               :vertical-align :baseline}]
   ;; Remove the default vertical scrollbar in IE.
   [:textarea {:overflow :auto}]
   [(attr= :type "checkbox")
    (attr= :type "radio")
    {;; Add the correct box sizing in IE 10-.
     :box-sizing :border-box
     ;; Remove the padding in IE 10-.
     :padding 0}]
   ;; Correct the cursor style of increment and decrement buttons in
   ;; Chrome.
   [((attr= :type "number") -webkit-inner-spin-button)
    ((attr= :type "number") -webkit-outer-spin-button)
    {:height :auto}]
   [(attr= :type "search") {;; Correct the odd appearance in Chrome and Safari.
                            :-webkit-appearance :textfield
                            ;; Correct the outline style in Safari.
                            :outline-offset (px -2)}]
   ;; Remove the inner padding and cancel buttons in Chrome and Safari on macOS.
   [((attr= :type "search") -webkit-search-cancel-button)
    ((attr= :type "search") -webkit-search-decoration)
    {:-webkit-appearance :none}]
   [-webkit-file-upload-button
    (merge
     ;; Correct the inability to style clickable types in iOS and Safari.
     {:-webkit-appearance :button}
     ;; Change font properties to `inherit` in Safari.
     {:font :inherit})]])

(def interactive
  [;; Add the correct display in IE 9-.
   [;; Add the correct display in Edge, IE, and Firefox.
    :details
    :menu
    {:display :block}]
   ;; Add the correct display in all browsers.
   [:summary
    {:display :list-item}]])

(def scripting
  [;; Add the correct display in IE 9-.
   [:canvas {:display :inline-block}]
   ;; Add the correct display in IE.
   [:template {:display :none}]])

(def hidden
  [;; Add the correct display in IE 10-.
   [(attr :hidden) {:display :none}]])

(def styles
  [document
   sections
   grouping
   text
   embedded
   forms
   interactive
   scripting
   hidden])

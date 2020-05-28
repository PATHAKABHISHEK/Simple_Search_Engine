object PlayingField {
    object Size {
        var width: Int = 0
        var height: Int = 0
        fun changeSize(_width: Int, _height: Int) {
            if (_width < 0) {
                width = 0
            } else if(_height  < 0) {
                height = 0
            } else {
                width = _width
                height = _height
            }
        }
    }
}

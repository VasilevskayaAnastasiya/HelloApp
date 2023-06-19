package lesson14

import java.awt.Point
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * Простая (2 балла)
 *
 * Рассчитать расстояние между двумя окружностями.
 * Расстояние между непересекающимися окружностями рассчитывается как
 * расстояние между их центрами минус сумма их радиусов.
 * Расстояние между пересекающимися окружностями считать равным 0.0.
 */
fun main() {
    val c1: Circle = Circle(Point(1, 1), 1.0)
    val c2: Circle = Circle(Point(2, 2), 2.0)
    println(c1.distance(c2))

}
data class Circle(val center: Point, val radius: Double){
    fun distance(other: Circle): Double{
        var dist: Double = 0.0;
        //расстояние между центрами
        val distPoint = sqrt((this.center.getX() - other.center.getX()).pow(2) + (this.center.getY() - other.center.getY()).pow(2));
        println(distPoint);

        //если окружности не пересекаются
        if(distPoint > this.radius + other.radius) {
            dist = distPoint - (this.radius + this.radius)
        }

        return dist;
    }
}
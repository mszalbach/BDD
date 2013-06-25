/**
 * Created with IntelliJ IDEA.
 * User: ms
 * Date: 5/3/13
 * Time: 8:47 AM
 * To change this template use File | Settings | File Templates.
 */
class TestStackSpock extends spock.lang.Specification {


  def "Basic functionality of a Stack"( ) {
    given: "Given an empty stack"
    def stack = new Stack()

    when: "When the string Java is added"
    stack.add( "Java" )
    and: "And the string C++ is added"
    stack.add( "C++" )
    and: "And the last element is removed again"
    stack.pop()

    then: "Then the resulting element should be Java"
    stack.pop() == "Java"

  }



  def "Stack search"( ) {

    println "Hallo"
    given: "an empty stack"
    def stack = new Stack()
    when: "the string Java is added"
    stack.add( "Java" )
    and: "the string C++ is added"
    stack.add( "C++" )
    and: "the string PHP is added"
    stack.add( "PHP" )
    then: "we check for the positions of the stack elements"
    stack.search( "Java" ) == 3
    stack.search( "C++" ) == 2
    stack.search( "PHP" ) == 1

  }



  def "pop from empty Stack"( ) {
    given: "an empty stack"
    def stack = new Stack()
    when: "the last element should be removed"
    stack.pop()
    then: "an EmptyStackException is thrown"
    EmptyStackException e = thrown()
    e.cause == null
  }

}

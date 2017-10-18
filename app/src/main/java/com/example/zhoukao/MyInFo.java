package com.example.zhoukao;

import java.util.List;

/**
 * Created by Administrator on 2017/9/15 0015.
 */
public class MyInFo {

    /**
     * Students : {"Student":[{"name":"寮犱笁","content":"瀛︾敓绠\u20ac浠嬪鐢熺畝浠嬪鐢熺畝浠嬪鐢熺畝浠嬪鐢熺畝浠�","img":"http:    "},{"name":"鏉庡洓","content":"杩欐槸涓\u20ac涓ソ瀛︾敓锛屽ソ濂藉涔狅紝鐗瑰埆鍔姏","img":"http:    "},{"name":"鐜嬩簲","content":"鍠滄璇讳功锛屽枩娆㈣嫳璇紝璁ょ湡瀛︿範鐨勬椂鍊欑壒鍒","img":"http:    "},{"name":"璧靛叚","content":"闀跨殑濂界湅锛屼釜澶村ぇ","img":"http:    "},{"name":"瀛欎竷","content":"鍔姏瀛︿範锛岃鐪熷伐浣�","img":"http:    "},{"name":"Alss","content":"瀛︿範濂斤紝鏄竴涓笁濂藉鐢燂紝鐝姳","img":"http:    "},{"name":"鍝囧搱鍝�","content":"瀛︿範濂斤紝鏄竴涓笁濂藉鐢�","img":"http:    "},{"name":"hander","content":"瀛︿範濂斤紝鏄竴涓笁濂藉鐢�","img":"http:    "},{"name":"EventBus","content":"瀛︿範濂斤紝鏄竴涓笁濂藉鐢�","img":"http:    "},{"name":"Android","content":"鍠滄鑻辫锛屾搮闀夸唬鐮�","img":"http:    "}]}
     */

    private StudentsBean Students;

    public StudentsBean getStudents() {
        return Students;
    }

    public void setStudents(StudentsBean Students) {
        this.Students = Students;
    }

    public static class StudentsBean {
        private List<StudentBean> Student;

        public List<StudentBean> getStudent() {
            return Student;
        }

        public void setStudent(List<StudentBean> Student) {
            this.Student = Student;
        }

        public static class StudentBean {
            /**
             * name : 寮犱笁
             * content : 瀛︾敓绠€浠嬪鐢熺畝浠嬪鐢熺畝浠嬪鐢熺畝浠嬪鐢熺畝浠�
             * img : http:
             */

            private String name;
            private String content;
            private String img;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}

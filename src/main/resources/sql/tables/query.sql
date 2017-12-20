SELECT s.name schoolname,g.year,c.name classname,st.name from bean_student st
LEFT JOIN bean_clazz c ON st.class_id = c.id
LEFT JOIN bean_grade g ON c.grade_id = g.id
LEFT JOIN bean_school s on g.school_id = s.id